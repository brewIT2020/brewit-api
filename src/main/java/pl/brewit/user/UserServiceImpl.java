package pl.brewit.user;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import pl.brewit.user.auth.crypt.PasswordEncryptor;

/**
 * Project: brewit-api
 *
 * <p>Created on: 06.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Inject
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public void save(User user) {
    encryptPassword(user);
    userRepository.save(user);
  }

  @Override
  public User findById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  private void encryptPassword(User user) {
    String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword());
    user.setPassword(encryptedPassword);
  }

  @Override
  public User findByEmail(String principal) {
    return userRepository.findByEmail(principal);
  }

  @Override
  public User findByUsername(String principal) {
    return userRepository.findByUsername(principal);
  }
}
