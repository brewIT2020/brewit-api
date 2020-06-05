package pl.brewit.brews.application;

import pl.brewit.brews.application.dto.BrewDetails;
import pl.brewit.brews.application.dto.BrewSimple;

import java.util.Set;
import java.util.UUID;

public interface BrewFacade {

    Set<BrewSimple> getBrewsSimple(String userId);
    BrewDetails getBrewDetails(UUID brewId);
    void insertBrew(BrewDetails brewDetails);
}


