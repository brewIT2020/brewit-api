package pl.brewit.brews.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.brewit.brews.repository.dao.Brew;
import pl.brewit.common.repository.SimpleCrudRepository;
import pl.brewit.user.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BrewRepositoryImpl extends SimpleCrudRepository<Brew> implements BrewRepository {

    @Inject
    public BrewRepositoryImpl(Provider<EntityManager> em) {
        super(em);
    }

    @Override
    public List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount) {
        CriteriaBuilder builder = getCriteriaBuilderForUser();
        CriteriaQuery<Brew> criteriaQuery = builder.createQuery(Brew.class);
        Root<Brew> brewRoot = criteriaQuery.from(Brew.class);
        criteriaQuery.select(brewRoot).where(
                builder.equal(brewRoot.get("user"), userId)
        );

        return getEntityManager().createQuery(criteriaQuery).setFirstResult(startIndex).setMaxResults(getAmount).getResultList();
    }
}
