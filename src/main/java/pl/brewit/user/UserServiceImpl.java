package pl.brewit.user;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * Project: brewit-api
 *
 * <p>Created on: 06.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class UserServiceImpl {

  private UserRepository userRepository;

  @Inject
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  void save(User user) {
    encryptPassword(user);
    userRepository.save(user);
  }

  private void encryptPassword(User user) {
    String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword());
    user.setPassword(encryptedPassword);
  }

  boolean authenticate(String login, String password) {
    User user = null;
    if (StringUtils.isNotBlank(login) && StringUtils.isNotBlank(password)) {
      user = EmailValidator.getInstance().isValid(login)
              ? userRepository.findByEmail(login)
              : userRepository.findByUsername(login);
      return PasswordEncryptor.verifyPassword(user.getPassword(), password);
    }
    return false;
  }
}
