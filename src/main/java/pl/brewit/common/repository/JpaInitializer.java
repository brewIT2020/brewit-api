package pl.brewit.common.repository;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * Project: brewit-api
 *
 * Created on: 24.03.2020
 *
 * Author    : Kamil Szerląg
 */
public class JpaInitializer {

  @Inject
  public JpaInitializer(PersistService persistService) {
    persistService.start();
  }
}
