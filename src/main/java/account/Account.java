package account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Project: brewit-api
 *
 * Created on: 22.03.2020
 *
 * Author : Kamil Szerląg
 */
@Entity(name = "accounts")
public class Account {

  @Id private Long id;

  @Column(name = "username", unique = true, nullable = false, length = 50, updatable = false)
  private String username;

  @Column(name = "email", unique = true, nullable = false, updatable = true)
  private String email;

  //Encrypted Password
  @Column(name = "password")
  @NotNull
  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
