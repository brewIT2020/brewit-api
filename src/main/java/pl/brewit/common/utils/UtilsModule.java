package pl.brewit.common.utils;

import com.google.inject.AbstractModule;

public class UtilsModule extends AbstractModule {
  protected void configure() {
    bind(AppProperties.class).asEagerSingleton();
  }
}
