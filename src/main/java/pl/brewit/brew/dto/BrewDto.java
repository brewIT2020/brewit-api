package pl.brewit.brew.dto;

import pl.brewit.brew.entity.Brew;
import pl.brewit.brew.entity.ProductParameter;

import javax.annotation.Nullable;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static pl.brewit.brew.dictionary.util.BrewDictionaryConst.*;

public class BrewDto {

  @Nullable private UUID id;

  @NotBlank
  @Size(min = 3, max = 75, message = "{validation.invalid.product.name}")
  private String productName;

  @Size(max = 200, message = "{validation.invalid.product.description}")
  @Nullable
  private String descShort;

  // Temperature - Celsius [°C]
  @Max(value = 120, message = "{validation.invalid.temp.max}")
  @Min(value = -50, message = "{validation.invalid.temp.max}")
  private Integer temp;

  // Time - Milliseconds [ms]
  @Max(value = 180, message = "{validation.invalid.time.max}")
  @Min(value = 0, message = "{validation.invalid.time.min}")
  private Integer time;

  // Volume - Milliliters [ml]
  @Max(value = 1000, message = "{validation.invalid.volume}")
  @Min(value = 0, message = "{validation.invalid.volume}")
  private Integer volume;

  // Weight - Grams [gm]
  private Integer weight;

  @PastOrPresent(message = "{validation.invalid.date.present}")
  @Nullable
  private LocalDate brewDate;

  @Size(max = 5000, message = "{validation.invalid.description.max}")
  @NotBlank
  private String description;

  private boolean isPublic;
  private UUID brewingToolsDictionaryId;
  private String userId;
  private ProductDto productDto;
  private Set<ProductParameterDto> productParameters;

  public BrewDto(
      UUID id,
      LocalDate brewDate,
      String description,
      boolean isPublic,
      UUID brewingToolsDictionaryId,
      String userId,
      ProductDto productDto,
      Set<ProductParameterDto> productParameters) {
    this.id = id;
    this.brewDate = brewDate;
    this.description = description;
    this.isPublic = isPublic;
    this.brewingToolsDictionaryId = brewingToolsDictionaryId;
    this.userId = userId;
    this.productDto = productDto;
    this.productParameters = productParameters;
  }

  private BrewDto(
      UUID id,
      String productName,
      Integer temp,
      Integer time,
      Integer volume,
      Integer weight,
      LocalDate brewDate,
      String description,
      String userId) {

    this.id = id;
    this.productName = productName;
    this.temp = temp;
    this.time = time;
    this.volume = volume;
    this.weight = weight;
    this.brewDate = brewDate;
    this.description = description;
    this.userId = userId;
  }

  public BrewDto() {}

  public static Optional<BrewDto> fillDataSimplifiedFromDao(Brew entity) {
    if (entity == null) return Optional.empty();
    int temp = 100;
    int time = 120;
    int weight = 10;
    int volume = 120;
    UUID id = entity.getId();
    String productName = entity.getProduct().getProductName();
    LocalDate brewDate = entity.getBrewDate();
    String description = entity.getDescription();
    boolean isPublic = entity.isPublic();
    String userId = entity.getUser().getId().toString();
    Set<ProductParameter> parameters = entity.getProduct().getProductParameterValues();
    for (ProductParameter productParameter : parameters) {
      // TODO : pobierac słowniki z bazy
      String parameterUUID = productParameter.getParameter().getId().toString();
      if (parameterUUID.equals(TEMP_UUID)) {
        temp = Integer.parseInt(productParameter.getParameterValue());
      }
      if (parameterUUID.equals(TIME_UUID)) {
        time = Integer.parseInt(productParameter.getParameterValue());
      }
      if (parameterUUID.equals(WEIGHT_UUID)) {
        weight = Integer.parseInt(productParameter.getParameterValue());
      }
    }

    return Optional.of(
        new BrewDto(id, productName, temp, time, volume, weight, brewDate, description, userId));
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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
