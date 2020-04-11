package pl.brewit.user.auth.filter;

import com.google.inject.Inject;
import io.javalin.http.Context;
import pl.brewit.user.UserDto;
import pl.brewit.user.auth.AuthenticationManager;
import pl.brewit.user.auth.UsernamePasswordAuthentication;

import javax.naming.AuthenticationException;
import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Project: brewit-api
 *
 * Created on: 07.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class JWTAuthenticationFilter implements Filter {

  private final AuthenticationManager authenticationManager;

  @Inject
  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    attemptAuthentication(request);

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }

  boolean attemptAuthentication(ServletRequest request) {
//    UserDto user = JavalinJson.getFromJsonMapper().map(, UserDto.class);
//
//
//    if (isValidToken(context.header(Header.AUTHORIZATION))) {
//      return true;
//    }
//    return false;
    return true;
  }

  boolean isValidToken(String authHeader) {
    return true;
  }

  boolean containsAuthorization() {
    return true;
  }

  boolean checkCredentials(Context context) {
    UserDto userDto = context.bodyAsClass(UserDto.class);
    String username = userDto.getUsername() != null ? userDto.getUsername() : userDto.getEmail();
    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthentication(username, userDto.getPassword(), new ArrayList<>())
      );
      return true;
    } catch (AuthenticationException e) {
      e.printStackTrace();
      return false;
    }
  }
}
