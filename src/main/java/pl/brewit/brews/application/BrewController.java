package pl.brewit.brews.application;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.Context;
import pl.brewit.brews.application.dto.Brew;
import pl.brewit.brews.application.dto.BrewSimple;

import java.util.List;
import java.util.UUID;

import static io.javalin.apibuilder.ApiBuilder.*;

@Singleton
public class BrewController {
    private Javalin javalin;

    private BrewFacade brewFacade;

    @Inject
    public BrewController(Javalin javalin, BrewFacade brewFacade) {
        this.javalin = javalin;
        this.brewFacade = brewFacade;
    }

    public EndpointGroup endpoints() {
        return () -> {
            get(this::getBrew);
            path(":brewSimple", () -> get(this::getBrewsSimpleForUserSortedByDateDesc));
        };
    }

    private void getBrewsSimpleForUserSortedByDateDesc(Context context) {
        String userIdString = context.queryParam("userId");
        String startIndexString = context.queryParam("startIndex");
        String getAmountString = context.queryParam("getAmount");
        List<BrewSimple> brewsSimple;

        if (userIdString != null && !userIdString.isEmpty() &&
                startIndexString != null && !startIndexString.isEmpty() &&
                getAmountString != null && !getAmountString.isEmpty()) {
            UUID userId = UUID.fromString(userIdString);
            int startIndex = Integer.parseInt(startIndexString);
            int getAmount = Integer.parseInt(getAmountString);
            brewsSimple = brewFacade.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
            context.json(brewsSimple);
            context.status(200);
        }
    }

    private void getBrew(Context context) {
        String brewIdString = context.queryParam("brewId");
        Brew brew;

        if (brewIdString != null && !brewIdString.isEmpty()) {
            UUID brewId = UUID.fromString(brewIdString);
            brew = brewFacade.getBrew(brewId);
            context.json(brew);
            context.status(200);
        }
    }

}
