package pl.brewit.brews.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ProductParameter {

    @NotBlank @Size(max = 100) private String value;
    private UUID productTypesDictionaryId;
    private UUID productParametersDictionaryId;

    public ProductParameter(@NotBlank @Size(max = 100) String value, UUID productTypesDictionaryId, UUID productParametersDictionaryId) {
        this.value = value;
        this.productTypesDictionaryId = productTypesDictionaryId;
        this.productParametersDictionaryId = productParametersDictionaryId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UUID getProductTypesDictionaryId() {
        return productTypesDictionaryId;
    }

    public void setProductTypesDictionaryId(UUID productTypesDictionaryId) {
        this.productTypesDictionaryId = productTypesDictionaryId;
    }

    public UUID getProductParametersDictionaryId() {
        return productParametersDictionaryId;
    }

    public void setProductParametersDictionaryId(UUID productParametersDictionaryId) {
        this.productParametersDictionaryId = productParametersDictionaryId;
    }
}
