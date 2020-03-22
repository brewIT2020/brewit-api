package pl.brewit.common.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Optional;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public abstract class AbstractCrudRepository<T> implements CrudRepository<T> {

  protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudRepository.class);

  // TODO: 22.03.2020 We must create singleton class letting us to inject EM in different place
  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BrewIT");

  @Override
  public void save(T object) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
      em.persist(object);
    } catch (PersistenceException e) {
      LOGGER.warn("Object with class {} can't be persisted", object.getClass().getName(), e);
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public void update(T object) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
      em.merge(object);
    } catch (PersistenceException e) {
      LOGGER.warn("Object with class {} can't be merged", object.getClass().getName(), e);
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public Optional<T> findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Class<T> type =
        ((Class)
            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    T entity = null;
    try {
      entity = (T) em.find(type, id);
    } finally {
      em.close();
    }
    return Optional.ofNullable(entity);
  }

  // TODO: 22.03.2020 creating criteria query for retriving all active entities
  @Override
  public Collection<T> findAll() {
    EntityManager em = emf.createEntityManager();
    return null;
  }

  // TODO: 22.03.2020 removing entity
  @Override
  public void remove(T object) {}

  public EntityManagerFactory getEmf() {
    return emf;
  }
}
