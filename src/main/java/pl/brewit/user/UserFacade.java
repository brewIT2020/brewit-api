package pl.brewit.user;

import com.google.inject.Singleton;

import java.util.List;

/**
 * Project: brewit-api
 *
 * Created on: 06.04.2020
 *
 * Author    : Kamil Szerląg
 */
public interface UserFacade {

  boolean register(UserDto userDto);

  UserDto getUser(String userId);

  List<UserDto> getAllUsers();

  void updateEmail(UserDto userDto);
}
