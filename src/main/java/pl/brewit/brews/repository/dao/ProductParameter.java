package pl.brewit.brews.repository.dao;

import pl.brewit.brews.repository.dao.Product;
import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.repository.ProductParametersDictionary;
import pl.brewit.dictionary.repository.ProductTypesDictionary;

import javax.persistence.*;

@Entity
@Table(name = "product_parameter", schema = "brews")
public class ProductParameter extends BaseEntity {

    @Column(name = "parameter_value")
    private String parameterValue;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypesDictionary productType;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private ProductParametersDictionary parameter;

    public String getParameterValue() { return parameterValue; }
    public void setParameterValue(String parameterValue) { this.parameterValue = parameterValue; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }

    public ProductParametersDictionary getParameter() { return parameter; }
    public void setParameter(ProductParametersDictionary parameter) { this.parameter = parameter; }

}
