package pl.brewit.brew;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.brewit.brew.dictionary.entity.ProductParametersDictionary;
import pl.brewit.common.repository.SimpleCrudRepository;

import javax.persistence.EntityManager;

public class ProductParametersDictionaryRepositoryImpl
    extends SimpleCrudRepository<ProductParametersDictionary>
    implements ProductParametersDictionaryRepository {

  @Inject
  public ProductParametersDictionaryRepositoryImpl(Provider<EntityManager> em) {
    super(em);
  }
}
