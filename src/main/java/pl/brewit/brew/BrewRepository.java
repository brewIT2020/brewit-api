package pl.brewit.brew;

import pl.brewit.brew.entity.Brew;
import pl.brewit.common.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BrewRepository extends CrudRepository<Brew> {
  List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int skipAmount, int getAmount);
}
