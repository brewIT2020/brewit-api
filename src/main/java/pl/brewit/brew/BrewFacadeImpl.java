package pl.brewit.brew;

import com.google.inject.Inject;
import pl.brewit.brew.dictionary.entity.ProductParametersDictionary;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;
import pl.brewit.brew.dictionary.util.BrewDictionaryConst;
import pl.brewit.brew.dto.BrewDto;
import pl.brewit.brew.entity.Brew;
import pl.brewit.brew.entity.Product;
import pl.brewit.brew.entity.ProductParameter;
import pl.brewit.user.User;
import pl.brewit.user.UserService;
import pl.brewit.user.auth.pac4jauth.SecurityContextHolder;

import javax.validation.*;
import java.time.ZonedDateTime;
import java.util.*;

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
    validate(brewDto);
    Brew brew = new Brew();
    User user = userService.findById(SecurityContextHolder.getContext().getUserProfile().getId());
    brew.setUser(user);
    brew.setBrewDate(ZonedDateTime.now().toLocalDate());
    brew.setDescription(brewDto.getDescription());
    Product product = new Product();
    product.setProductName(brewDto.getProductName());

    ProductTypesDictionary coffeeType =
        brewService.getBasicProductParameterType(BrewDictionaryConst.COFFEE).orElseThrow();
    product.setProductType(coffeeType);
    Set<ProductParameter> productParameters = new HashSet<>();

    // Setting parameters value for basic brew model...
    // TEMPERATURE
    ProductParameter tempParameter = new ProductParameter();
    ProductParametersDictionary temperatureParameterName =
        brewService.getBasicProductParameterName(BrewDictionaryConst.TEMPERATURE).orElseThrow();
    tempParameter.setParameter(temperatureParameterName);
    tempParameter.setProductType(coffeeType);
    tempParameter.setParameterValue(brewDto.getTemp().toString());
    productParameters.add(tempParameter);
    // TIME
    ProductParameter timeParameter = new ProductParameter();
    ProductParametersDictionary timeParameterName =
        brewService.getBasicProductParameterName(BrewDictionaryConst.TIME).orElseThrow();
    timeParameter.setParameter(timeParameterName);
    timeParameter.setProductType(coffeeType);
    timeParameter.setParameterValue(brewDto.getTemp().toString());
    productParameters.add(timeParameter);

    // WEIGHT
    ProductParameter weightParameter = new ProductParameter();
    ProductParametersDictionary weightParameterName =
        brewService.getBasicProductParameterName(BrewDictionaryConst.WEIGHT).orElseThrow();
    weightParameter.setParameter(weightParameterName);
    weightParameter.setProductType(coffeeType);
    weightParameter.setParameterValue(brewDto.getTemp().toString());
    productParameters.add(weightParameter);

    product.setProductType(coffeeType);
    product.setProductParameterValues(productParameters);
    brew.setProduct(product);

    brewService.saveBrew(brew);
  }

  private void validate(BrewDto brewDto) {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validation = validatorFactory.getValidator();
    Set<ConstraintViolation<BrewDto>> violations = validation.validate(brewDto);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
