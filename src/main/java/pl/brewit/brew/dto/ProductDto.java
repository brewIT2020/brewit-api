package pl.brewit.brew.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class ProductDto {

  @NotBlank
  @Size(max = 75)
  private String name;

  private boolean isTemplate;
  private UUID countriesDictionaryId;
  private UUID productTypesDictionaryId;
  private Set<ProductParameterDto> productParameters;

  public ProductDto(
      @NotBlank @Size(max = 75) String name,
      boolean isTemplate,
      UUID countriesDictionaryId,
      UUID productTypesDictionaryId,
      Set<ProductParameterDto> productParameters) {
    this.name = name;
    this.isTemplate = isTemplate;
    this.countriesDictionaryId = countriesDictionaryId;
    this.productTypesDictionaryId = productTypesDictionaryId;
    this.productParameters = productParameters;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isTemplate() {
    return isTemplate;
  }

  public void setTemplate(boolean template) {
    isTemplate = template;
  }

  public UUID getCountriesDictionaryId() {
    return countriesDictionaryId;
  }

  public void setCountriesDictionaryId(UUID countriesDictionaryId) {
    this.countriesDictionaryId = countriesDictionaryId;
  }

  public UUID getProductTypesDictionaryId() {
    return productTypesDictionaryId;
  }

  public void setProductTypesDictionaryId(UUID productTypesDictionaryId) {
    this.productTypesDictionaryId = productTypesDictionaryId;
  }

  public Set<ProductParameterDto> getProductParameters() {
    return productParameters;
  }

  public void setProductParameters(Set<ProductParameterDto> productParameters) {
    this.productParameters = productParameters;
  }
}
