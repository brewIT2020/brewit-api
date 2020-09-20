package pl.brewit.brew;

import pl.brewit.brew.dto.BrewDto;

import java.util.List;
import java.util.UUID;

public interface BrewFacade {

  List<BrewDto> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount);

  BrewDto getBrew(UUID brewId);

  void createBrew(BrewDto brewDto);
}
