package pl.brewit.user.auth;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import pl.brewit.user.User;
import pl.brewit.user.UserService;
import pl.brewit.user.auth.crypt.PasswordEncryptor;

import javax.naming.AuthenticationException;

/**
 * Project: brewit-api
 *
 * <p>Created on: 07.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
@Singleton
public class JWTAuthenticationManager implements AuthenticationManager {

  private UserService userService;

  @Inject
  public JWTAuthenticationManager(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Authentication authenticate(Authentication auth) throws AuthenticationException {
    User user = null;
    if (StringUtils.isNotBlank(auth.getPrincipal())
        && StringUtils.isNotBlank(auth.getCredentials())) {
      user =
          EmailValidator.getInstance().isValid(auth.getPrincipal())
              ? userService.findByEmail(auth.getPrincipal())
              : userService.findByUsername(auth.getPrincipal());
      boolean isCorrectCredentials =
          PasswordEncryptor.verifyPassword(user.getPassword(), auth.getCredentials());
      auth.setAuthenticated(isCorrectCredentials);
      return auth;
    }
    throw new AuthenticationException("Invalid username or password");
  }

}
