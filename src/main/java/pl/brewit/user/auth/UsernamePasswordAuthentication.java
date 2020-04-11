package pl.brewit.user.auth;

import io.javalin.core.security.Role;


import java.util.Collection;
import java.util.List;

/**
 * Project: brewit-api
 *
 * Created on: 07.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class UsernamePasswordAuthentication implements Authentication {

  private final String username;
  private final String password;
  private final List<Role> roles;

  private boolean authenticated = false;

  public UsernamePasswordAuthentication(String username, String password, List<Role> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  @Override
  public String getPrincipal() {
    return username;
  }

  @Override
  public Collection<Role> getAuthorities() {
    return roles;
  }

  @Override
  public String getCredentials() {
    return password;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) {
    this.authenticated = isAuthenticated;
  }
}
