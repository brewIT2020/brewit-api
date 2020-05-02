package pl.brewit.common.server;

import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import io.javalin.Javalin;
import org.eclipse.jetty.servlet.FilterHolder;
import pl.brewit.user.auth.filter.JWTAuthenticationFilter;
import pl.brewit.user.auth.filter.JWTAuthorizationFilter;
import pl.brewit.user.auth.pac4jauth.BasicUsernamePasswordAuthenticator;
import pl.brewit.user.auth.pac4jauth.RequestMatcher;
import pl.brewit.user.auth.pac4jauth.SecurityConfig;

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

  public Javalin app(final Injector injector) {
    return Javalin.create(
        config -> {
          config.configureServletContextHandler(
              servletContextHandler -> {
                servletContextHandler.addFilter(
                    new FilterHolder(injector.getInstance(PersistFilter.class)), "/*", of(REQUEST));
                servletContextHandler.addFilter(
                    new FilterHolder(
                        new JWTAuthenticationFilter(
                            injector.getInstance(BasicUsernamePasswordAuthenticator.class),
                            injector.getInstance(RequestMatcher.class),
                            injector.getInstance(SecurityConfig.class))),
                    "/*",
                    of(REQUEST));
                servletContextHandler.addFilter(
                    new FilterHolder(
                        new JWTAuthorizationFilter(
                            injector.getInstance(SecurityConfig.class),
                            injector.getInstance(RequestMatcher.class))),
                    "/*",
                    of(REQUEST));
              });
        });
  }
}
