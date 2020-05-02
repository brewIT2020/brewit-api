package pl.brewit.dictionary.domain;

import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;

@Entity(name = "productParametersDictionary")
public class ProductParametersDictionaryModel extends BaseEntity {

    @Column(name = "parameterName", nullable = false, updatable = false)
    private String parameterName;

    @Column(name = "valueName", nullable = false, updatable = false)
    private String valueName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private ProductTypesDictionaryModel productType;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public ProductTypesDictionaryModel getProductType() {
        return productType;
    }

    public void setProductType(ProductTypesDictionaryModel productType) {
        this.productType = productType;
    }
}
