package pl.brewit.user.auth;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;
import pl.brewit.user.auth.AuthenticationManager;
import pl.brewit.user.auth.JWTAuthenticationManager;
import pl.brewit.user.auth.filter.JWTAuthorizationFilter;

/**
 * Project: brewit-api
 *
 * Created on: 11.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class AuthModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(AuthenticationManager.class).to(JWTAuthenticationManager.class).in(Singleton.class);
    bind(JWTAuthenticationManager.class);
    bind(JWTAuthorizationFilter.class);
  }
}
