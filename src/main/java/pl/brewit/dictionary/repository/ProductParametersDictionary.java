package pl.brewit.dictionary.repository;

import javax.persistence.*;

import pl.brewit.brews.repository.dao.ProductParameter;
import pl.brewit.common.repository.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "product_parameters", schema = "\"dictionaries\"")
public class ProductParametersDictionary extends BaseEntity {

    @Column(name = "parameter_name", nullable = false, updatable = false)
    private String parameterName;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypesDictionary productType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parameter")
    private Set<ProductParameter> productParameters;

    public String getParameterName() { return parameterName; }
    public void setParameterName(String parameterName) { this.parameterName = parameterName; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }

    public Set<ProductParameter> getProductParameters() { return productParameters; }
    private void setProductParameters(Set<ProductParameter> productParameters) { this.productParameters = productParameters; }
}
