package pl.brewit.brews.application;

import com.google.inject.Inject;
import pl.brewit.brews.application.dto.Brew;
import pl.brewit.brews.application.dto.BrewSimple;

import java.util.List;
import java.util.UUID;

public class BrewFacadeImpl implements BrewFacade {
    private static final String BASIC_MODE = "Basic";
    private static final String GOD_MODE = "GODMode";

    private BrewService brewService;

    @Inject
    public BrewFacadeImpl(BrewService brewService) {
        this.brewService = brewService;
    }

    @Override
    public List<BrewSimple> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount) {
        List<pl.brewit.brews.repository.dao.Brew> brews = brewService.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
        return null;
    }

    @Override
    public Brew getBrew(UUID brewId) {
        return null;
    }

    @Override
    public void postBrew(Brew brew) { }
}
