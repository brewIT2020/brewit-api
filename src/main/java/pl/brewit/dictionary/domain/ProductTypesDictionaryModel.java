package pl.brewit.dictionary.domain;

import pl.brewit.common.repository.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "productTypesDictionary")
public class ProductTypesDictionaryModel extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    public String getName() { return name; }
    public void setName(String parameterName) { this.name = parameterName; }
}