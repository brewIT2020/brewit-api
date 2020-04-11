package pl.brewit.user.auth.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Project: brewit-api
 *
 * Created on: 07.04.2020
 *
 * Author    : Kamil Szerląg
 */
public class JWTAuthorizationFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

  }

  @Override
  public void destroy() {

  }
}
