package pl.brewit.dictionary.repository;

import pl.brewit.brews.repository.Brew;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "brewingToolsDictionary")
public class BrewingToolsDictionary extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @ManyToOne
    private ProductTypesDictionary productType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brewingToolsDictionaryId")
    private Set<Brew> brews;

    public String getName() { return name; }
    public void setName(String parameterName) { this.name = parameterName; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }

    public Set<Brew> getBrews() { return brews; }
    private void setBrews(Set<Brew> brews) { this.brews = brews; }
}


