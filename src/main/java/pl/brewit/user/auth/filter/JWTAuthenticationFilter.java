package pl.brewit.user.auth.filter;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.pac4j.core.authorization.generator.AuthorizationGenerator;
import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.jwt.profile.JwtGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.brewit.common.utils.AppProperties;
import pl.brewit.user.UserDto;
import pl.brewit.user.auth.pac4jauth.BasicUsernamePasswordAuthenticator;
import pl.brewit.user.auth.pac4jauth.RequestMatcher;
import pl.brewit.user.auth.pac4jauth.SecurityConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Set;

/**
 * Project: brewit-api
 *
 * <p>Created on: 07.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class JWTAuthenticationFilter implements Filter {

  private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

  private static final String SECRET_KEY = "JWT_SECRET";
  private static final String EXPIRATION_TIME = "JWT_EXPIRATION_TIME";

  private final BasicUsernamePasswordAuthenticator usernamePasswordAuthenticator;

  private final RequestMatcher requestMatcher;

  private final SecurityConfig securityConfig;

  @Inject AppProperties properties;

  @Inject
  public JWTAuthenticationFilter(
      BasicUsernamePasswordAuthenticator usernamePasswordAuthenticator,
      RequestMatcher requestMatcher,
      SecurityConfig securityConfig) {
    this.usernamePasswordAuthenticator = usernamePasswordAuthenticator;
    this.requestMatcher = requestMatcher;
    this.securityConfig = securityConfig;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    WebContext context =
        new J2EContext((HttpServletRequest) request, (HttpServletResponse) response);

    CommonProfile commonProfile = null;
    try {
      Reader reader = new InputStreamReader(request.getInputStream());
      UserDto userDto = new Gson().fromJson(reader, UserDto.class);

      commonProfile =
          usernamePasswordAuthenticator.validate(
              new UsernamePasswordCredentials(
                  userDto.getUsername() != null ? userDto.getUsername() : userDto.getEmail(),
                  userDto.getPassword()));

    } catch (IOException e) {
      throw new RuntimeException();
    } catch (CredentialsException e) {
      unsuccessfulAuth();
    } catch (HttpAction e) {
      // TODO: 4/21/20 Implementation of HttpActionAdapter to handling HttpAction exception
    } catch (Exception e) {
      LOGGER.debug(e.getMessage(), e);
      LOGGER.error(e.getMessage(), e);
    }

    successfulAuth(commonProfile, context);
    chain.doFilter(request, response);
  }

  // TODO: 4/21/20 Create JWT token contains required payload.
  private void successfulAuth(CommonProfile profile, WebContext context) {
    AuthorizationGenerator<CommonProfile> authorizationGenerator =
        securityConfig.getAuthorizationGenerator();
    authorizationGenerator.generate(context, profile);
    JwtGenerator<CommonProfile> jwtGenerator = securityConfig.getJwtGenerator();
    String token = jwtGenerator.generate(profile);
    context.setResponseHeader(
        HttpConstants.AUTHORIZATION_HEADER, HttpConstants.BEARER_HEADER_PREFIX + token);
  }

  private void unsuccessfulAuth() {}

  @Override
  public void destroy() {}
}
