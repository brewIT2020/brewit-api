package pl.brewit.user;

import pl.brewit.common.repository.CrudRepository;

import java.util.List;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
// TODO: 22.03.2020
public interface UserRepository extends CrudRepository<User> {

    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);
}
