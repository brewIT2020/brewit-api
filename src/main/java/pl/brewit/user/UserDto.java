package pl.brewit.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * Project: brewit-api
 *
 * <p>Created on: 07.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class UserDto {

  @NotBlank
  @Max(value = 50, message = "Can't size can't be higher then 50 chars")
  private String username;

  @Email private String email;

  // TODO: 07.04.2020 implement Regex for user password
  @NotBlank private String password;

  private String role;

  public UserDto() {}

  public UserDto(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
