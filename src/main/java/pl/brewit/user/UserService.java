package pl.brewit.user;

import com.google.inject.Inject;

/**
 * Project: brewit-api
 * <p>
 * Created on: 06.04.2020
 * <p>
 * Author    : Kamil Szerląg
 */
public interface UserService {

    void save(User user);

    User findByEmail(String principal);

    User findByUsername(String principal);
}
