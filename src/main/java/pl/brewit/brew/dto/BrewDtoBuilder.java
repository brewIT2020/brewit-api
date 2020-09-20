package pl.brewit.brew.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class BrewDtoBuilder {
  private UUID id;
  private LocalDate brewDate;
  private String description;
  private boolean isPublic;
  private UUID brewingToolsDictionaryId;
  private String user;
  private ProductDto productDto;
  private Set<ProductParameterDto> productParameters;
  private @NotBlank @Size(max = 75) String productName;
  private Short temp;
  private Short time;
  private Short volume;
  private Short weight;

  public BrewDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BrewDtoBuilder setBrewDate(LocalDate brewDate) {
    this.brewDate = brewDate;
    return this;
  }

  public BrewDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BrewDtoBuilder setIsPublic(boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

  public BrewDtoBuilder setBrewingToolsDictionaryId(UUID brewingToolsDictionaryId) {
    this.brewingToolsDictionaryId = brewingToolsDictionaryId;
    return this;
  }

  public BrewDtoBuilder setUser(String user) {
    this.user = user;
    return this;
  }

  public BrewDtoBuilder setProductDto(ProductDto productDto) {
    this.productDto = productDto;
    return this;
  }

  public BrewDtoBuilder setProductParameters(Set<ProductParameterDto> productParameters) {
    this.productParameters = productParameters;
    return this;
  }

  public BrewDtoBuilder setProductName(@NotBlank @Size(max = 75) String productName) {
    this.productName = productName;
    return this;
  }

  public BrewDtoBuilder setTemp(Short temp) {
    this.temp = temp;
    return this;
  }

  public BrewDtoBuilder setTime(Short time) {
    this.time = time;
    return this;
  }

  public BrewDtoBuilder setVolume(Short volume) {
    this.volume = volume;
    return this;
  }

  public BrewDtoBuilder setWeight(Short weight) {
    this.weight = weight;
    return this;
  }

  public BrewDto build() {
    return new BrewDto(
        id,
        brewDate,
        description,
        isPublic,
        brewingToolsDictionaryId,
        user,
        productDto,
        productParameters);
  }
}
