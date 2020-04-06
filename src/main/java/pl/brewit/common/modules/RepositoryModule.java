package pl.brewit.common.modules;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import pl.brewit.common.repository.CrudRepository;
import pl.brewit.common.repository.JpaInitializer;
import pl.brewit.common.repository.SimpleCrudRepository;
import pl.brewit.user.UserRepository;
import pl.brewit.user.UserRepositoryImpl;

/**
 * Project: brewit-api
 *
 * <p>Created on: 24.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class RepositoryModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new JpaPersistModule("BrewIT"));
    bind(UserRepository.class).to(UserRepositoryImpl.class);
    bind(CrudRepository.class).to(SimpleCrudRepository.class);
    bind(JpaInitializer.class);
  }
}
