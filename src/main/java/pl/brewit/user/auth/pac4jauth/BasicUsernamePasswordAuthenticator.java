package pl.brewit.user.auth.pac4jauth;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.definition.CommonProfileDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.brewit.user.User;
import pl.brewit.user.UserService;
import pl.brewit.user.auth.crypt.PasswordEncryptor;
/**
 * Project: brewit-api
 * <p>
 * Created on: 22.03.2020
 * <p>
 * Author : Kamil Szerląg
 */

public class BasicUsernamePasswordAuthenticator implements Authenticator {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(BasicUsernamePasswordAuthenticator.class);

  private final UserService userService;

  @Inject
  public BasicUsernamePasswordAuthenticator(UserService userService) {
    this.userService = userService;
  }

  public CommonProfile validate(Credentials credentials) {
    try {
      validate(credentials, null);
    } catch (CredentialsException e) {
      LOGGER.info(
          "Authentication Failed! Username: {}", credentials.getUserProfile().getUsername());
    }
    return credentials.getUserProfile();
  }

  @Override
  public void validate(Credentials credentials, WebContext context) {
    UsernamePasswordCredentials credits = (UsernamePasswordCredentials) credentials;
    User user;
    if (StringUtils.isNotBlank(credits.getUsername())
        && StringUtils.isNotBlank(credits.getPassword())) {
      user =
          EmailValidator.getInstance().isValid(credits.getUsername())
              ? userService.findByEmail(credits.getUsername())
              : userService.findByUsername(credits.getUsername());
      boolean isCorrectCredentials =
          PasswordEncryptor.verifyPassword(credits.getPassword(), user.getPassword());
      if (isCorrectCredentials) {
        createCommonProfile(credentials, user);
        return;
      }
    }
    throw new CredentialsException("Invalid username or password");
  }

  private void createCommonProfile(Credentials credentials, User user) {
    CommonProfile commonProfile = new CommonProfile();
    commonProfile.setId(user.getId().toString());
    commonProfile.addAttribute(Pac4jConstants.USERNAME, user.getUsername());
    commonProfile.addAttribute(CommonProfileDefinition.EMAIL, user.getEmail());
    credentials.setUserProfile(commonProfile);
  }
}
