package pl.brewit.user;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import static de.mkammerer.argon2.Argon2Factory.Argon2Types;

/**
 * Project: brewit-api
 *
 * Created on: 06.04.2020
 *
 * Author    : Kamil Szerląg
 */
class PasswordEncryptor {

  private static final Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2i);

  static String encryptPassword(String password) {
    String hash = argon2.hash(4, 1024 * 1024, 4, password);
    return hash;
  }

  static boolean verifyPassword(String hash, String password) {
    Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2i);
    return argon2.verify(hash, password);
  }
}
