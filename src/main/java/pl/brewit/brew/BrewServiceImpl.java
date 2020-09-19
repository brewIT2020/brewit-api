package pl.brewit.brew;

import com.google.inject.Inject;
import pl.brewit.brew.entity.Brew;

import java.util.List;
import java.util.UUID;

public class BrewServiceImpl implements BrewService {

  private BrewRepository brewRepository;

  @Inject
  public BrewServiceImpl(BrewRepository brewRepository) {
    this.brewRepository = brewRepository;
  }

  @Override
  public List<Brew> getBrewsSimpleForUserSortedByDateDesc(
      UUID userId, int startIndex, int getAmount) {
    return brewRepository.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
  }

  @Override
  public void saveBrew(Brew brew) {
    brewRepository.save(brew);
  }
}
