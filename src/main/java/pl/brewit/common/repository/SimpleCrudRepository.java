package pl.brewit.common.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;
import java.util.UUID;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
@Singleton
public class SimpleCrudRepository<T> implements CrudRepository<T> {

  protected static final Logger LOGGER = LoggerFactory.getLogger(SimpleCrudRepository.class);

  // TODO: 22.03.2020 We must create singleton class letting us to inject EM in different place

  private Provider<EntityManager> em;

  @Inject
  public SimpleCrudRepository(Provider<EntityManager> em) {
    this.em = em;
  }

  protected EntityManager getEntityManager() {
    return em.get();
  }

  protected CriteriaBuilder getCriteriaBuilderForUser() {
    return getEntityManager().getCriteriaBuilder();
  }

  @Override
  public void save(T object) {
    try {
      getEntityManager().persist(object);
    } catch (PersistenceException e) {
      LOGGER.warn("Object with class {} can't be persisted", object.getClass().getName(), e);
      getEntityManager().getTransaction().rollback();
    }
  }

  @Override
  public void update(T object) {
    getEntityManager().getTransaction().begin();
    try {
      getEntityManager().merge(object);
    } catch (PersistenceException e) {
      LOGGER.warn("Object with class {} can't be merged", object.getClass().getName(), e);
      getEntityManager().getTransaction().rollback();
    } finally {
      getEntityManager().close();
    }
  }

  @Override
  public Optional<T> findById(Long id) {
    Class<T> type =
        ((Class)
            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    T entity = null;
    try {
      entity = (T) getEntityManager().find(type, id);
    } finally {
      getEntityManager().close();
    }
    return Optional.ofNullable(entity);
  }

  @Override
  public Optional<T> findById(UUID id) {
    Class<T> type =
            ((Class)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    T entity = null;
    try {
      entity = (T) getEntityManager().find(type, id);
    } finally {
      getEntityManager().close();
    }
    return Optional.ofNullable(entity);
  }

  // TODO: 22.03.2020 creating criteria query for retriving all active entities
//  @Override
//  public Collection<T> findAll() {
//    CriteriaBuilder cb = getEntityManager().createQuery();
//  }

  // TODO: 22.03.2020 removing entity
  @Override
  public void remove(T object) {}
}
