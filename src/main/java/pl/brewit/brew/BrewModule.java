package pl.brewit.brew;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class BrewModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BrewRepository.class).to(BrewRepositoryImpl.class).in(Singleton.class);
        bind(BrewService.class).to(BrewServiceImpl.class).in(Singleton.class);
        bind(BrewFacade.class).to(BrewFacadeImpl.class).in(Singleton.class);
        bind(BrewController.class).in(Singleton.class);
    }
}
