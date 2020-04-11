package pl.brewit.common.server;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import io.javalin.Javalin;
import org.eclipse.jetty.servlet.FilterHolder;
import pl.brewit.user.auth.AuthenticationManager;
import pl.brewit.user.auth.filter.JWTAuthenticationFilter;
import pl.brewit.user.auth.filter.JWTAuthorizationFilter;

import java.util.EnumSet;

import static java.util.EnumSet.of;
import static javax.servlet.DispatcherType.REQUEST;

/**
 * Project: brewit-api
 *
 * <p>Created on: 24.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public final class JavalinWebServer {

  private AuthenticationManager authenticationManager;

  @Inject
  public JavalinWebServer(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public Javalin app(final Injector injector) {
    return Javalin.create(
            config -> {
              config.configureServletContextHandler(
                      servletContextHandler -> {
                        servletContextHandler.addFilter(
                                new FilterHolder(injector.getInstance(PersistFilter.class)),
                                "/",
                                of(REQUEST)
                        );
                        servletContextHandler.addFilter(
                                JWTAuthenticationFilter.class,
                                "/",
                                of(REQUEST));
                        servletContextHandler.addFilter(
                                JWTAuthorizationFilter.class,
                                "/",
                                of(REQUEST));
                      });
            });
  }
}
