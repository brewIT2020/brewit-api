package pl.brewit.brew.dto;

import pl.brewit.brew.entity.Brew;
import pl.brewit.brew.entity.ProductParameter;
import pl.brewit.user.UserDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class BrewDto {

  private UUID id;

  @NotBlank
  @Size(max = 75) private String productName;
  @NotBlank @Size(max = 200) private String descShort;
  //Temperature - Celsius [°C]
  private Integer temp;
  //Time - Milliseconds [ms]
  private Integer time;
  //Volume - Milliliters [ml]
  private Integer volume;
  //Weight - Grams [gm]
  private Integer weight;

  @Past private LocalDate brewDate;

  @Size(max = 5000)
  private String description;

  private boolean isPublic;
  private UUID brewingToolsDictionaryId;
  private UserDto user;
  private ProductDto productDto;
  private Set<ProductParameterDto> productParameters;

  public BrewDto(
      UUID id,
      LocalDate brewDate,
      String description,
      boolean isPublic,
      UUID brewingToolsDictionaryId,
      UserDto user,
      ProductDto productDto,
      Set<ProductParameterDto> productParameters) {
    this.id = id;
    this.brewDate = brewDate;
    this.description = description;
    this.isPublic = isPublic;
    this.brewingToolsDictionaryId = brewingToolsDictionaryId;
    this.user = user;
    this.productDto = productDto;
    this.productParameters = productParameters;
  }

  private BrewDto(UUID id, @NotBlank @Size(max = 75) String productName, Integer temp, Integer time, Integer volume, Integer weight, @Past LocalDate brewDate, @Size(max = 5000) String description) {
    this.id = id;
    this.productName = productName;
    this.temp = temp;
    this.time = time;
    this.volume = volume;
    this.weight = weight;
    this.brewDate = brewDate;
    this.description = description;
  }

  public static BrewDto createBasicBrewFrom(Brew entity) {
    Set<ProductParameter> parameters = entity.getProduct().getProductParameterValues();
    Integer temp = null;
    Integer time = null;
    Integer volume = null;
    Integer weight = null;

    for (Iterator<ProductParameter> iterator = parameters.iterator(); iterator.hasNext(); ) {
      ProductParameter productParameter = iterator.next();
      if (productParameter.getParameter().getParameterName().equals("Temperatura")) {
        temp = productParameter.getParameterValue();
      }

    }

    return new BrewDto(entity.getId(), entity.getProduct().getProductName(), temp , time, volume, weight, entity.getBrewDate(), entity.getDescription());
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getDescShort() {
    return descShort;
  }

  public void setDescShort(String descShort) {
    this.descShort = descShort;
  }

  public Integer getTemp() {
    return temp;
  }

  public void setTemp(Integer temp) {
    this.temp = temp;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public LocalDate getBrewDate() {
    return brewDate;
  }

  public void setBrewDate(LocalDate brewDate) {
    this.brewDate = brewDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public UUID getBrewingToolsDictionaryId() {
    return brewingToolsDictionaryId;
  }

  public void setBrewingToolsDictionaryId(UUID brewingToolsDictionaryId) {
    this.brewingToolsDictionaryId = brewingToolsDictionaryId;
  }

  public UserDto getUser() {
    return user;
  }

  public void setUser(UserDto user) {
    this.user = user;
  }

  public ProductDto getProductDto() {
    return productDto;
  }

  public void setProductDto(ProductDto productDto) {
    this.productDto = productDto;
  }

  public Set<ProductParameterDto> getProductParameters() {
    return productParameters;
  }

  public void setProductParameters(Set<ProductParameterDto> productParameters) {
    this.productParameters = productParameters;
  }
}