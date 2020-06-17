package pl.brewit.user.auth.filter;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.pac4j.core.authorization.authorizer.IsAuthenticatedAuthorizer;
import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import pl.brewit.user.auth.pac4jauth.RequestMatcher;
import pl.brewit.user.auth.pac4jauth.SecurityConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project: brewit-api
 *
 * <p>Created on: 07.04.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class JWTAuthorizationFilter implements Filter {

  private SecurityConfig securityConfig;

  private RequestMatcher requestMatcher;

  @Inject
  public JWTAuthorizationFilter(SecurityConfig securityConfig, RequestMatcher requestMatcher) {
    this.securityConfig = securityConfig;
    this.requestMatcher = requestMatcher;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    JwtAuthenticator jwtAuthenticator = securityConfig.getJwtAuthenticator();
    J2EContext context =
        new J2EContext((HttpServletRequest) request, (HttpServletResponse) response);

    String authHeader = ((HttpServletRequest) request).getHeader("Authorization");
    if (authHeader == null || !authHeader.contains(HttpConstants.BEARER_HEADER_PREFIX)) {
      if (requestMatcher.requiresAuthentication(context)) {
        unsuccessfulAuthorization(response);
      }
      chain.doFilter(request, response);
      return;
    }

    CommonProfile commonProfile =
        jwtAuthenticator.validateToken(authHeader.replace(HttpConstants.BEARER_HEADER_PREFIX, ""));

    // TODO: 16.06.2020 When commonProfile is Authorized should be added to the User context
    if (!IsAuthenticatedAuthorizer.isAuthenticated().isProfileAuthorized(context, commonProfile)) {
      unsuccessfulAuthorization(response);
    }

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

  public void unsuccessfulAuthorization(ServletResponse response) throws IOException {
    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
  }
}
