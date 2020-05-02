package pl.brewit.brews.repository;

import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.repository.CountriesDictionary;
import pl.brewit.dictionary.repository.ProductTypesDictionary;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class Product extends BaseEntity {

    @Column(name = "productName")
    private String productName;

    @ManyToOne
    private CountriesDictionary country;

    @ManyToOne
    private ProductTypesDictionary productType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Set<Brew> brews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Set<ProductParameter> productParameters;

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public CountriesDictionary getCountry() { return country; }
    public void setCountry(CountriesDictionary country) { this.country = country; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }

    public Set<Brew> getBrews() { return brews; }
    private void setBrews(Set<Brew> brews) { this.brews = brews; }

    public Set<ProductParameter> getProductParameters() { return productParameters; }
    public void setProductParameters(Set<ProductParameter> products) { this.productParameters = products; }
}
