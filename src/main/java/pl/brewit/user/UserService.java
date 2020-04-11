package pl.brewit.user;

import com.google.inject.Inject;

/**
 * Project: brewit-api
 *
 * Created on: 06.04.2020
 *
 * Author    : Kamil Szerląg
 */
public interface UserService {

  void save(User user);

  User findByEmail(String principal);

  User findByUsername(String principal);
}
