package pl.brewit.brew;

import pl.brewit.brew.entity.Brew;

import java.util.List;
import java.util.UUID;

public interface BrewService {
    List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount);
}
