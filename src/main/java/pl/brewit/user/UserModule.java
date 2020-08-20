package pl.brewit.user;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Project: brewit-api
 *
 * <p>Created on: 06.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class UserModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserRepository.class).to(UserRepositoryImpl.class).in(Singleton.class);
    bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
    bind(UserFacade.class).to(UserFacadeImpl.class).in(Singleton.class);
    bind(UserController.class).in(Singleton.class);
  }
}
