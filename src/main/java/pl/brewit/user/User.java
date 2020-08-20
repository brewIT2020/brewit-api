package pl.brewit.user;

import com.google.common.base.Objects;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
@Entity
@Table(name = "user", schema = "\"users\"")
public class User extends BaseEntity {

  @Column(name = "username", unique = true, nullable = false, length = 50, updatable = false)
  private String username;

  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;

  // Encrypted Password
  @Column(name = "password")
  @NotBlank
  private String password;

  // TODO: 4/22/20 Add Roles
  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private AuthorizationRole authorizationRole;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AuthorizationRole getAuthorizationRole() {
    return authorizationRole;
  }

  public void setAuthorizationRole(AuthorizationRole authorizationRole) {
    this.authorizationRole = authorizationRole;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equal(id, user.id) && Objects.equal(username, user.username);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, username);
  }
}
