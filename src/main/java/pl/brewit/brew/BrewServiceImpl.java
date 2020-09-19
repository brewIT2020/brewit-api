package pl.brewit.brew;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import pl.brewit.brew.dictionary.entity.ProductParametersDictionary;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;
import pl.brewit.brew.dictionary.util.BrewDictionaryUtil;
import pl.brewit.brew.entity.Brew;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BrewServiceImpl implements BrewService {

  private BrewRepository brewRepository;
  private ProductParametersDictionaryRepository productParametersDictionaryRepository;
  private ProductTypesDictionaryRepository productTypesDictionaryRepository;

  @Inject
  public BrewServiceImpl(
      BrewRepository brewRepository,
      ProductParametersDictionaryRepository productParametersDictionaryRepository,
      ProductTypesDictionaryRepository productTypesDictionaryRepository) {
    this.brewRepository = brewRepository;
    this.productParametersDictionaryRepository = productParametersDictionaryRepository;
    this.productTypesDictionaryRepository = productTypesDictionaryRepository;
  }

  @Override
  public List<Brew> getBrewsSimpleForUserSortedByDateDesc(
      UUID userId, int startIndex, int getAmount) {
    return brewRepository.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
  }

  @Override
  @Transactional
  public void saveBrew(Brew brew) {
    brewRepository.save(brew);
  }

  @Override
  public Optional<ProductParametersDictionary> getBasicProductParameterName(String name) {
    return productParametersDictionaryRepository.findById(
        BrewDictionaryUtil.getBasicProductParameterUUID(name));
  }

  @Override
  public Optional<ProductTypesDictionary> getBasicProductParameterType(String type) {
    return productTypesDictionaryRepository.findById(
        BrewDictionaryUtil.getBasicProductParameterTypeUUID(type));
  }
}
