package pl.brewit.user;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import pl.brewit.common.repository.SimpleCrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
// TODO: 22.03.20
class UserRepositoryImpl extends SimpleCrudRepository<User> implements UserRepository {

    @Inject
    public UserRepositoryImpl(Provider<EntityManager> em) {
        super(em);
    }

    @Override
    public List<User> findAll() {
        CriteriaQuery<User> q = getCriteriaBuilderForUser().createQuery(User.class);
        Root<User> c = q.from(User.class);
        q.select(c);
        TypedQuery<User> query = getEntityManager().createQuery(q);
        return query.getResultList();
    }

    @Override
    public User findByUsername(String username) {
        return getUsersByColumn(username, "username");
    }

    @Override
    public User findByEmail(String email) {
        return getUsersByColumn(email, "email");
    }

    private User getUsersByColumn(String parameterValue, String queryColumn) {
        CriteriaQuery<User> q = getCriteriaBuilderForUser().createQuery(User.class);
        Root<User> c = q.from(User.class);
        ParameterExpression<String> p = getCriteriaBuilderForUser().parameter(String.class, "username");
        q.select(c).where(getCriteriaBuilderForUser().equal(c.get(queryColumn), p));
        TypedQuery<User> query = getEntityManager().createQuery(q);
        query.setParameter(p, parameterValue);
        return query.getSingleResult();
    }
}
