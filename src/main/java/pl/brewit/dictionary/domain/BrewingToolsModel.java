package pl.brewit.dictionary.domain;

import pl.brewit.brews.domain.ProductModel;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;

@Entity(name = "productParametersDictionary")
public class BrewingToolsModel extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private ProductTypesDictionaryModel productType;

    public String getName() { return name; }
    public void setName(String parameterName) { this.name = parameterName; }

    public ProductTypesDictionaryModel getProductType() { return productType; }
    public void setProductType(ProductTypesDictionaryModel productType) { this.productType = productType; }
}


