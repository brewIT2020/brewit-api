package pl.brewit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import io.javalin.Javalin;
import pl.brewit.user.auth.AuthModule;
import pl.brewit.common.repository.RepositoryModule;
import pl.brewit.common.server.WebServerModule;
import pl.brewit.common.repository.JpaInitializer;
import pl.brewit.common.server.JavalinWebServer;
import pl.brewit.user.UserController;
import pl.brewit.user.UserModule;

import static io.javalin.apibuilder.ApiBuilder.path;

/**
 * Hello world!
 */
public class App {

  private static final String JPA_UNIT_BREWIT = "BrewIT";

  public static void main(String[] args) {
    // Injecting modules for application DI
    Injector injector = Guice.createInjector(
            new WebServerModule(),
            new RepositoryModule(),
            new ServletModule(),
            new UserModule(),
            new AuthModule()
            //...
    );


    injector.getInstance(JpaInitializer.class);
    injector.injectMembers(PersistFilter.class);
    Javalin app = injector.getInstance(JavalinWebServer.class).app(injector)
            .routes(() -> {
              path("users", injector.getInstance(UserController.class).endpoints());
            }).start(7000);

  }
}
