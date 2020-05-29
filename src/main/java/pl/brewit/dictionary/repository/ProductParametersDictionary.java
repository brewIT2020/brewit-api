package pl.brewit.dictionary.repository;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import pl.brewit.brews.repository.dao.ProductParameter;
import pl.brewit.common.repository.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "product_parameters", schema = "\"dictionaries\"")
public class ProductParametersDictionary extends BaseEntity {

    @Column(name = "parameter_name", nullable = false, updatable = false)
    private String parameterName;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false,
        foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameter_product_type"))
    private ProductTypesDictionary productType;


    public String getParameterName() { return parameterName; }
    public void setParameterName(String parameterName) { this.parameterName = parameterName; }

    public ProductTypesDictionary getProductType() { return productType; }
    public void setProductType(ProductTypesDictionary productType) { this.productType = productType; }
}
