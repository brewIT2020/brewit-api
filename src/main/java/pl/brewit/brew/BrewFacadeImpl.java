package pl.brewit.brew;

import com.google.inject.Inject;
import pl.brewit.brew.dto.BrewDto;
import pl.brewit.brew.entity.Brew;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrewFacadeImpl implements BrewFacade {

    private BrewService brewService;

    @Inject
    public BrewFacadeImpl(BrewService brewService) {
        this.brewService = brewService;
    }

    @Override
    public List<BrewDto> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount) {
        List<Brew> brews = brewService.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
        List<BrewDto> brewDtos = new ArrayList<>();
        for (Brew brew : brews) {
//            new BrewDto(brew)
//            brewDtos.add()
        }
        return null;
    }

    @Override
    public BrewDto getBrew(UUID brewId) {
        return null;
    }

    @Override
    public void createBrew(BrewDto brewDto) { }
}
