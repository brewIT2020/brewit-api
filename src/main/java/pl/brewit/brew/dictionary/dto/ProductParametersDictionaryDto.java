package pl.brewit.brew.dictionary.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ProductParametersDictionaryDto extends BaseDictionaryDto {

  private UUID unitDictionaryId;

  public ProductParametersDictionaryDto(
      UUID id, @NotBlank @Size(max = 100) String name, UUID unitDictionaryId) {
    super(id, name);
    this.unitDictionaryId = unitDictionaryId;
  }

  public UUID getUnitDictionaryId() {
    return unitDictionaryId;
  }

  public void setUnitDictionaryId(UUID unitDictionaryId) {
    this.unitDictionaryId = unitDictionaryId;
  }
}
