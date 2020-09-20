package pl.brewit.brew;

import pl.brewit.brew.dictionary.entity.ProductParametersDictionary;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;
import pl.brewit.brew.entity.Brew;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrewService {
  List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount);

  void saveBrew(Brew brew);

  Optional<ProductParametersDictionary> getBasicProductParameterName(String name);

  Optional<ProductTypesDictionary> getBasicProductParameterType(String name);
}
