package pl.brewit.user;

import com.google.inject.Inject;

import java.util.List;

/**
 * Project: brewit-api
 *
 * Created on: 11.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class UserFacadeImpl implements UserFacade {

  private static final String BASIC_MODE = "Basic";
  private static final String GOD_MODE = "GODMode";

  private UserService userService;

  @Inject
  public UserFacadeImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean register(final UserDto userDto) {
    final User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setEmail(userDto.getEmail());
    assignAuthorizationRole(userDto, user);
    userService.save(user);
    return true;
  }

  private void assignAuthorizationRole(final UserDto userDto, final User user) {
    if (userDto.getMode() == null || userDto.getMode().equalsIgnoreCase(BASIC_MODE)) {
      user.setAuthorizationRole(AuthorizationRole.BASIC);
      return;
    }
    if (userDto.getMode().equals(GOD_MODE)) {
      user.setAuthorizationRole(AuthorizationRole.GOD);
      return;
    }
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
