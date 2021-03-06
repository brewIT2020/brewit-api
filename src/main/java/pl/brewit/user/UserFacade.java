package pl.brewit.user;

import java.util.List;

/**
 * Project: brewit-api
 *
 * <p>Created on: 06.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public interface UserFacade {

  boolean register(UserDto userDto);

  UserDto getUser(String userId);

  List<UserDto> getAllUsers();

  void updateUser(String userId, UserDto userDto);
}
