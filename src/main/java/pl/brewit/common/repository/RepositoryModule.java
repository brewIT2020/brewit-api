package pl.brewit.common.repository;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

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
    bind(CrudRepository.class).to(SimpleCrudRepository.class);
    bind(JpaInitializer.class);
  }
}
