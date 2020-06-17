package pl.brewit.brews.application;

import pl.brewit.brews.repository.dao.Brew;

import java.util.List;
import java.util.UUID;

public interface BrewService {
    List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount);
}
