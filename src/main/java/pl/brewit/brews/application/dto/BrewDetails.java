package pl.brewit.brews.application.dto;

import org.hibernate.annotations.Cascade;
import pl.brewit.brews.repository.dao.BrewRanking;
import pl.brewit.dictionary.repository.BrewingToolsDictionary;
import pl.brewit.user.UserDto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class BrewDetails {

    private UUID id;
    @Past private LocalDate brewDate;
    @Size(max = 5000) private String description;
    private boolean isPublic;
    private UUID brewingToolsDictionaryId;
    private UserDto user;
    private Product product;
    private Set<ProductParameter> productParameters;

    public BrewDetails(UUID id, @Past LocalDate brewDate, @Size(max = 5000) String description, boolean isPublic,
                       UUID brewingToolsDictionaryId, UserDto user, Product product, Set<ProductParameter> productParameters) {
        this.id = id;
        this.brewDate = brewDate;
        this.description = description;
        this.isPublic = isPublic;
        this.brewingToolsDictionaryId = brewingToolsDictionaryId;
        this.user = user;
        this.product = product;
        this.productParameters = productParameters;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<ProductParameter> getProductParameters() {
        return productParameters;
    }

    public void setProductParameters(Set<ProductParameter> productParameters) {
        this.productParameters = productParameters;
    }
}
