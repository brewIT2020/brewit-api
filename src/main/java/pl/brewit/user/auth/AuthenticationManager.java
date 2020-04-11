package pl.brewit.user.auth;

import javax.naming.AuthenticationException;

/**
 * Project: brewit-api
 *
 * Created on: 07.04.2020
 *
 * Author    : Kamil Szerląg
 */
public interface AuthenticationManager {

  Authentication authenticate(Authentication auth) throws AuthenticationException;

}
