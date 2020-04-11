package pl.brewit.user.auth;

import io.javalin.core.security.Role;

import java.util.Collection;

/**
 * Project: brewit-api
 *
 * Created on: 07.04.2020
 *
 * Author    : Kamil Szerląg
 */
public interface Authentication {

  String getPrincipal();

  Collection<Role> getAuthorities();

  String getCredentials();

  boolean isAuthenticated();

  void setAuthenticated(boolean isAuthenticated);
}
