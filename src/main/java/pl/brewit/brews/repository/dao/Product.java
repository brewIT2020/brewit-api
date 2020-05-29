package pl.brewit.brews.repository.dao;

import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.repository.CountriesDictionary;
import pl.brewit.dictionary.repository.ProductTypesDictionary;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product", schema = "\"brews\"")
public class Product extends BaseEntity {

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "country_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_country"))
    private CountriesDictionary country;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_product_type"))
    private ProductTypesDictionary productType;

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public CountriesDictionary getCountry() { return country; }
    public void setCountry(CountriesDictionary country) { this.country = country; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }
}
