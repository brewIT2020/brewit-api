package pl.brewit.brew.dictionary.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class ProductTypesDictionaryDto extends BaseDictionaryDto {

    private Set<UUID> productParametersDictionaryIds;
    private Set<UUID> brewingToolsDictionaryIds;

    public ProductTypesDictionaryDto(UUID id, @NotBlank @Size(max = 100) String name, Set<UUID> productParametersDictionaryIds, Set<UUID> brewingToolsDictionaryIds) {
        super(id, name);
        this.productParametersDictionaryIds = productParametersDictionaryIds;
        this.brewingToolsDictionaryIds = brewingToolsDictionaryIds;
    }

    public Set<UUID> getProductParametersDictionaryIds() {
        return productParametersDictionaryIds;
    }

    public void setProductParametersDictionaryIds(Set<UUID> productParametersDictionaryIds) {
        this.productParametersDictionaryIds = productParametersDictionaryIds;
    }

    public Set<UUID> getBrewingToolsDictionaryIds() {
        return brewingToolsDictionaryIds;
    }

    public void setBrewingToolsDictionaryIds(Set<UUID> brewingToolsDictionaryIds) {
        this.brewingToolsDictionaryIds = brewingToolsDictionaryIds;
    }
}
