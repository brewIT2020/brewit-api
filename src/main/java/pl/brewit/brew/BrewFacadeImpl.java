package pl.brewit.brew;

import com.google.inject.Inject;
import pl.brewit.brew.dto.BrewDto;
import pl.brewit.brew.entity.Brew;
import pl.brewit.user.User;
import pl.brewit.user.UserService;
import pl.brewit.user.auth.pac4jauth.SecurityContextHolder;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrewFacadeImpl implements BrewFacade {

  private final BrewService brewService;
  private final UserService userService;

  @Inject
  public BrewFacadeImpl(BrewService brewService, UserService userService) {
    this.brewService = brewService;
    this.userService = userService;
  }

  @Override
  public List<BrewDto> getBrewsSimpleForUserSortedByDateDesc(
      UUID userId, int startIndex, int getAmount) {
    List<Brew> brews =
        brewService.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
    List<BrewDto> dtos = new ArrayList<>();
    for (Brew dao : brews) {
      var dto = BrewDto.fillDataSimplifiedFromDao(dao);
      dto.ifPresent(dtos::add);
    }
    return dtos;
  }

  @Override
  public BrewDto getBrew(UUID brewId) {
    return null;
  }

  @Override
  public void createBrew(BrewDto brewDto) {
    Brew brew = new Brew();
    User user = userService.findById(SecurityContextHolder.getContext().getUserProfile().getId());
    brew.setUser(user);
    brew.setBrewDate(ZonedDateTime.now().toLocalDate());
    brew.setDescription(brew.getDescription());
//    brew.setProduct();
    // TODO: 29.06.2020 Setting parameters for brew (╯°□°)╯︵ ┻━┻
    brewService.saveBrew(brew);
  }
}
