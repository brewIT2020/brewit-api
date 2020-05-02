package pl.brewit.user.auth.crypt;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.mindrot.jbcrypt.BCrypt;
import org.pac4j.core.credentials.password.JBCryptPasswordEncoder;

import static de.mkammerer.argon2.Argon2Factory.Argon2Types;

/**
 * Project: brewit-api
 *
 * Created on: 06.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class PasswordEncryptor {

  private static final JBCryptPasswordEncoder jbCryptPasswordEncoder = new JBCryptPasswordEncoder(BCrypt.gensalt(10));
  public static String encryptPassword(String password) {
    return jbCryptPasswordEncoder.encode(password);

  }

  public static boolean verifyPassword(String password, String hash) {
    return jbCryptPasswordEncoder.matches(password, hash);
  }
}
