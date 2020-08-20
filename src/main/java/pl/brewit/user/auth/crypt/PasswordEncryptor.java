package pl.brewit.user.auth.crypt;

import org.mindrot.jbcrypt.BCrypt;
import org.pac4j.core.credentials.password.JBCryptPasswordEncoder;

/**
 * Project: brewit-api
 *
 * <p>Created on: 06.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class PasswordEncryptor {

  private static final JBCryptPasswordEncoder jbCryptPasswordEncoder =
      new JBCryptPasswordEncoder(BCrypt.gensalt(10));

  public static String encryptPassword(String password) {
    return jbCryptPasswordEncoder.encode(password);
  }

  public static boolean verifyPassword(String password, String hash) {
    return jbCryptPasswordEncoder.matches(password, hash);
  }
}
