package pl.brewit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;
import io.javalin.Javalin;
import pl.brewit.brew.BrewController;
import pl.brewit.brew.BrewModule;
import pl.brewit.common.handler.ResponseExceptionHandler;
import pl.brewit.common.repository.RepositoryModule;
import pl.brewit.common.server.JavalinWebServer;
import pl.brewit.common.server.WebServerModule;
import pl.brewit.common.utils.UtilsModule;
import pl.brewit.user.UserController;
import pl.brewit.user.UserModule;
import pl.brewit.user.auth.AuthModule;
import pl.brewit.user.auth.pac4jauth.SecurityConfig;

import javax.validation.ConstraintViolationException;

import static io.javalin.apibuilder.ApiBuilder.path;

/** Hello world! */
public class App {

  private static final String JPA_UNIT_BREWIT = "BrewIT";

  public static void main(String[] args) {
    // Injecting modules for application DI
    Injector injector =
        Guice.createInjector(
            new WebServerModule(),
            new UtilsModule(),
            new RepositoryModule(),
            new ServletModule(),
            new UserModule(),
            new AuthModule(),
            new BrewModule()
            // ...
            );

    injector.getInstance(SecurityConfig.class).configure();

    // Mappings for controllers
    Javalin app =
        injector
            .getInstance(JavalinWebServer.class)
            .app(injector)
            .post("/login", ctx -> {})
            .post("/sign-up", injector.getInstance(UserController.class)::signUp)
            .routes(
                () -> {
                  path("users", injector.getInstance(UserController.class).endpoints());
                  path("brews", injector.getInstance(BrewController.class).endpoints());
                })
            .exception(
                ConstraintViolationException.class,
                (exception, ctx) -> {
                  injector
                      .getInstance(ResponseExceptionHandler.class)
                      .handleException(exception, ctx);
                });
    app.start(7000);
  }
}
