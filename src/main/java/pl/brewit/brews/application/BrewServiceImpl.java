package pl.brewit.brews.application;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import pl.brewit.brews.repository.BrewRepository;
import pl.brewit.brews.repository.dao.Brew;
import pl.brewit.user.User;
import pl.brewit.user.UserRepository;
import pl.brewit.user.auth.crypt.PasswordEncryptor;

import java.util.List;
import java.util.UUID;

public class BrewServiceImpl implements BrewService {

    private BrewRepository brewRepository;

    @Inject
    public BrewServiceImpl(BrewRepository brewRepository) {
        this.brewRepository = brewRepository;
    }

    @Override
    public List<Brew> getBrewsSimpleForUserSortedByDateDesc(UUID userId, int startIndex, int getAmount) {
        return brewRepository.getBrewsSimpleForUserSortedByDateDesc(userId, startIndex, getAmount);
    }
}
