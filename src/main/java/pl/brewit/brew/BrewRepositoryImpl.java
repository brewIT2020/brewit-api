package pl.brewit.brew;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.brewit.brew.entity.Brew;
import pl.brewit.common.repository.SimpleCrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
