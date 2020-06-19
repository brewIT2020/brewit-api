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
    public BrewController(BrewFacade brewFacade) {
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
        BrewDto brewDto = context.bodyAsClass(BrewDto.class);
        brewFacade.createBrew(brewDto);
    }

    private void getBrewsBasicForUserSortedByDateDesc(Context context) {
        String userIdString = context.queryParam("userId");
        String startIndexString = context.queryParam("startIndex");
        String getAmountString = context.queryParam("getAmount");
        List<BrewDto> brews;

        if (userIdString != null && !userIdString.isEmpty() &&
                startIndexString != null && !startIndexString.isEmpty() &&
                getAmountString != null && !getAmountString.isEmpty()) {
            UUID userId = UUID.fromString(userIdString);
            int startIndex = Integer.parseInt(startIndexString);
            int getAmount = Integer.parseInt(getAmountString);
            brews = brewFacade.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
            context.json(brews);
            context.status(200);
        }
    }

    private void getBrew(Context context) {
        String brewIdString = context.queryParam("brewId");
        BrewDto brewDto;

        if (brewIdString != null && !brewIdString.isEmpty()) {
            UUID brewId = UUID.fromString(brewIdString);
            brewDto = brewFacade.getBrew(brewId);
            context.json(brewDto);
            context.status(200);
        }
    }

}
