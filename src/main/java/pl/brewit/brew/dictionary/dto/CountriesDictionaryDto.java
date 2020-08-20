package pl.brewit.brew.dictionary.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CountriesDictionaryDto extends BaseDictionaryDto {

  @NotBlank
  @Size(max = 3)
  private String Code;

  public CountriesDictionaryDto(
      UUID id, @NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 3) String code) {
    super(id, name);
    Code = code;
  }

  public String getCode() {
    return Code;
  }

  public void setCode(String code) {
    Code = code;
  }
}
