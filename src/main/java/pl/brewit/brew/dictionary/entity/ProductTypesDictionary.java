package pl.brewit.brew.dictionary.entity;

import org.hibernate.annotations.Cascade;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_types", schema = "\"dictionaries\"")
public class ProductTypesDictionary extends BaseEntity {

    @Column(name = "type_name", nullable = false)
    private String name;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "product_type_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_product_type"))
    private Set<ProductParametersDictionary> productParametersDictionaries;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "product_type_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brewing_tools_product_type"))
    private Set<BrewingToolsDictionary> brewingToolsDictionaries;

    public ProductTypesDictionary() {

    }

    public ProductTypesDictionary(String name, Set<ProductParametersDictionary> productParametersDictionaries, Set<BrewingToolsDictionary> brewingToolsDictionaries) {
        this.name = name;
        this.productParametersDictionaries = productParametersDictionaries;
        this.brewingToolsDictionaries = brewingToolsDictionaries;
    }

    public String getName() {
        return name;
    }

    public void setName(String typeName) {
        this.name = typeName;
    }

    public Set<ProductParametersDictionary> getProductParametersDictionaries() {
        return productParametersDictionaries;
    }

    public void setProductParametersDictionaries(Set<ProductParametersDictionary> productParametersDictionaries) {
        this.productParametersDictionaries = productParametersDictionaries;
    }

    public Set<BrewingToolsDictionary> getBrewingToolsDictionaries() {
        return brewingToolsDictionaries;
    }

    public void setBrewingToolsDictionaries(Set<BrewingToolsDictionary> brewingToolsDictionaries) {
        this.brewingToolsDictionaries = brewingToolsDictionaries;
    }
}