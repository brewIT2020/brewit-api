package pl.brewit.common.server;

import com.google.inject.AbstractModule;

/**
 * Project: brewit-api
 *
 * <p>Created on: 24.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class WebServerModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(JavalinWebServer.class).asEagerSingleton();
  }
}
