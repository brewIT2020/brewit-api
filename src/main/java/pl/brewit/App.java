package pl.brewit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import pl.brewit.common.modules.RepositoryModule;
import pl.brewit.common.modules.WebServerModule;
import pl.brewit.common.repository.JpaInitializer;
import pl.brewit.common.server.JavalinWebServer;

/** Hello world! */
public class App {

  private static final String JPA_UNIT_BREWIT = "BrewIT";

  public static void main(String[] args) {
    // Injecting modules for application DI
    Injector injector = Guice.createInjector(
            new WebServerModule(),
            new RepositoryModule(),
            new JpaPersistModule(JPA_UNIT_BREWIT)
            //...
    );

    injector.getInstance(JavalinWebServer.class).start();
  }

}
