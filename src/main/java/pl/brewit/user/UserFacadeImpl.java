package pl.brewit.user;

import com.google.inject.Inject;

import java.util.List;
import java.util.UUID;

/**
 * Project: brewit-api
 *
 * <p>Created on: 11.04.2020
 *
 * <p>Author : Kamil Szerląg
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
    if (userDto.getRole() == null || userDto.getRole().equalsIgnoreCase(BASIC_MODE)) {
      user.setAuthorizationRole(AuthorizationRole.USER);
    } else if (userDto.getRole().equals(GOD_MODE)) {
      user.setAuthorizationRole(AuthorizationRole.ADMIN);
    }
  }

  @Override
  public UserDto getUser(String userId) {
    User user = userService.findById(userId);
    UserDto userDto = new UserDto();
    userDto.setUsername(user.getUsername());
    userDto.setEmail(user.getEmail());
    userDto.setRole(user.getAuthorizationRole().toString());
    return userDto;
  }

  @Override
  public List<UserDto> getAllUsers() {
    return null;
  }

  @Override
  public void updateUser(String userId, UserDto userDto) {
    User user = userService.findById(userId);
  }
}
