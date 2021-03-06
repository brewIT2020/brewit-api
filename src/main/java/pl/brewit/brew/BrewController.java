package pl.brewit.brew;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.Context;
import pl.brewit.brew.dto.BrewDto;

import java.util.List;
import java.util.UUID;

import static io.javalin.apibuilder.ApiBuilder.*;

@Singleton
public class BrewController {

  private BrewFacade brewFacade;

  @Inject
  public BrewController(final BrewFacade brewFacade) {
    this.brewFacade = brewFacade;
  }

  public EndpointGroup endpoints() {
    return () -> {
      post(this::createBrew);
      get(this::getBrew);
      path(":brewSimple", () -> get(this::getBrewsBasicForUserSortedByDateDesc));
    };
  }

  private void createBrew(Context context) {
    final BrewDto brewDto = context.bodyAsClass(BrewDto.class);
    brewFacade.createBrew(brewDto);
  }

  private void getBrew(Context context) {
    final String brewIdString = context.queryParam("brewId");
    BrewDto brewDto;

    if (brewIdString != null && !brewIdString.isEmpty()) {
      UUID brewId = UUID.fromString(brewIdString);
      brewDto = brewFacade.getBrew(brewId);
      context.json(brewDto);
      context.status(200);
    }
  }

  private void getBrewsBasicForUserSortedByDateDesc(Context context) {
    var userId = context.queryParam("userId");
    var startIndexString = context.queryParam("startIndex");
    var getAmountString = context.queryParam("getAmount");
    List<BrewDto> brews;

    // TODO : pobierz usera z contextu
    if (userId == null || userId.isEmpty()) {
      context.status(401);
      return;
    }
    if (startIndexString == null || startIndexString.isEmpty()) {
      startIndexString = "0";
    }
    if (getAmountString == null || getAmountString.isEmpty()) {
      getAmountString = "50";
    }

    var userUuid = UUID.fromString(userId);
    var startIndex = Integer.parseInt(startIndexString);
    var getAmount = Integer.parseInt(getAmountString);
    brews = brewFacade.getBrewsSimpleForUserSortedByDateDesc(userUuid, startIndex, getAmount);
    context.json(brews);
    context.status(200);
  }
}
