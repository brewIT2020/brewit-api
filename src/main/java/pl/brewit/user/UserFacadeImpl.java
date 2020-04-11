package pl.brewit.user;

import java.util.List;

/**
 * Project: brewit-api
 *
 * Created on: 11.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class UserFacadeImpl implements UserFacade {
  @Override
  public boolean register(UserDto userDto) {
    return false;
  }

  @Override
  public UserDto getUser(String userId) {
    return null;
  }

  @Override
  public List<UserDto> getAllUsers() {
    return null;
  }

  @Override
  public void updateEmail(UserDto userDto) {

  }
}
