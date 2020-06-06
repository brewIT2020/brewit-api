package pl.brewit.brews.application;

import pl.brewit.brews.application.dto.Brew;
import pl.brewit.brews.application.dto.BrewSimple;

import java.util.List;
import java.util.UUID;

public interface BrewFacade {

    List<BrewSimple> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount);
    Brew getBrew(UUID brewId);
    void postBrew(Brew brew);
}


