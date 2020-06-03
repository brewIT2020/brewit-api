package pl.brewit.brews.application.dto;

import org.hibernate.annotations.Cascade;
import pl.brewit.user.UserDto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class Product {

    @NotBlank @Size(max = 75) private String name;
    private boolean isTemplate;
    private UUID countriesDictionaryId;
    private UUID productTypesDictionaryId;
    private Set<ProductParameter> productParameters;

    public Product(@NotBlank @Size(max = 75) String name, boolean isTemplate, UUID countriesDictionaryId,
                   UUID productTypesDictionaryId, Set<ProductParameter> productParameters) {
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

    public Set<ProductParameter> getProductParameters() {
        return productParameters;
    }

    public void setProductParameters(Set<ProductParameter> productParameters) {
        this.productParameters = productParameters;
    }
}
