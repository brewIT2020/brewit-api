package pl.brewit.user.auth;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import pl.brewit.user.auth.filter.JWTAuthorizationFilter;
import pl.brewit.user.auth.pac4jauth.BasicUsernamePasswordAuthenticator;
import pl.brewit.user.auth.pac4jauth.RequestMatcher;
import pl.brewit.user.auth.pac4jauth.SecurityConfig;

/**
 * Project: brewit-api
 *
 * <p>Created on: 11.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class AuthModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(JWTAuthorizationFilter.class);
    bind(RequestMatcher.class).in(Singleton.class);
    bind(BasicUsernamePasswordAuthenticator.class).in(Singleton.class);
    bind(SecurityConfig.class).in(Singleton.class);
  }
}
