package pl.brewit.brew.entity;

import pl.brewit.common.repository.BaseEntity;
import pl.brewit.brew.dictionary.entity.ProductParametersDictionary;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;

import javax.persistence.*;

@Entity
@Table(name = "product_parameter", schema = "brews")
public class ProductParameter extends BaseEntity {

    @Column(name = "parameter_value")
    private String parameterValue;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_product_type"))
    private ProductTypesDictionary productType;

    @ManyToOne
    @JoinColumn(name = "parameter_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_parameter"))
    private ProductParametersDictionary parameter;

    public ProductParameter() {

    }

    public ProductParameter(String parameterValue, ProductTypesDictionary productType, ProductParametersDictionary parameter) {
        this.parameterValue = parameterValue;
        this.productType = productType;
        this.parameter = parameter;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public ProductTypesDictionary getProductType() {
        return productType;
    }

    public void setProductType(ProductTypesDictionary productType) {
        this.productType = productType;
    }

    public ProductParametersDictionary getParameter() {
        return parameter;
    }

    public void setParameter(ProductParametersDictionary parameter) {
        this.parameter = parameter;
    }
}
