package pl.brewit.brew;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;
import pl.brewit.common.repository.SimpleCrudRepository;

import javax.persistence.EntityManager;

public class ProductTypesDictionaryRepositoryImpl
    extends SimpleCrudRepository<ProductTypesDictionary> implements ProductTypesDictionaryRepository {

  @Inject
  public ProductTypesDictionaryRepositoryImpl(Provider<EntityManager> em) {
    super(em);
  }
}
