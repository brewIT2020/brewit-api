package pl.brewit.user;

import com.google.inject.Inject;

import java.util.UUID;

/**
 * Project: brewit-api
 * <p>
 * Created on: 06.04.2020
 * <p>
 * Author    : Kamil Szerląg
 */
public interface UserService {

    void save(User user);

    User findById(UUID id);

    User findByEmail(String principal);

    User findByUsername(String principal);
}
