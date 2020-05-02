package pl.brewit.brews.repository;

import pl.brewit.dictionary.repository.ProductParametersDictionary;
import pl.brewit.dictionary.repository.ProductTypesDictionary;

import javax.persistence.*;

@Entity(name = "productParameter")
public class ProductParameter {

    @Column(name = "parameterValue")
    private String parameterValue;

    @ManyToOne
    private ProductTypesDictionary productType;

    @ManyToOne
    private ProductParametersDictionary productParameter;

    @ManyToOne
    private Product product;

    public String getParameterValue() { return parameterValue; }
    public void setParameterValue(String parameterValue) { this.parameterValue = parameterValue; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }

    public ProductParametersDictionary getProductParameter() { return productParameter; }
    public void setProductParameter(ProductParametersDictionary productParameter) { this.productParameter = productParameter; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

}
