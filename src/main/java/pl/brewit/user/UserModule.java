package pl.brewit.user;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Project: brewit-api
 *
 * Created on: 06.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class UserModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserRepository.class).to(UserRepositoryImpl.class).in(Singleton.class);
  }
}