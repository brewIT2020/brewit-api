package pl.brewit.brews.repository;

import pl.brewit.brews.repository.dao.Brew;
import pl.brewit.common.repository.CrudRepository;
import pl.brewit.user.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface BrewRepository extends CrudRepository<Brew> {
    List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int skipAmount, int getAmount);
}
