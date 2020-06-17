package pl.brewit.dictionary.repository.dao;

import javax.persistence.*;

import pl.brewit.common.repository.BaseEntity;

@Entity
@Table(name = "product_parameters", schema = "\"dictionaries\"")
public class ProductParametersDictionary extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String parameterName;

    @ManyToOne
    @JoinColumn(name = "unit_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_unit"))
    private UnitsDictionary unit;

    public ProductParametersDictionary() {

    }

    public ProductParametersDictionary(String parameterName, UnitsDictionary unit) {
        this.parameterName = parameterName;
        this.unit = unit;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public UnitsDictionary getUnit() {
        return unit;
    }

    public void setUnit(UnitsDictionary unit) {
        this.unit = unit;
    }
}
