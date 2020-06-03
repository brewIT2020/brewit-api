package pl.brewit.dictionary.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ProductParametersDictionary extends BaseDictionary {

    private UUID unitDictionaryId;

    public ProductParametersDictionary(UUID id, @NotBlank @Size(max = 100) String name, UUID unitDictionaryId) {
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
