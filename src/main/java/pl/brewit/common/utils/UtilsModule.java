package pl.brewit.common.utils;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import pl.brewit.common.handler.ResponseExceptionHandler;

public class UtilsModule extends AbstractModule {
  protected void configure() {
    bind(AppPropertiesUtil.class).asEagerSingleton();
    bind(ResponseExceptionHandler.class).in(Singleton.class);
  }
}
