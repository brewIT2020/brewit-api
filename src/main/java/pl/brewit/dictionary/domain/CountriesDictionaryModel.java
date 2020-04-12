package pl.brewit.dictionary.domain;

import pl.brewit.common.repository.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "countriesDictionary")
public class CountriesDictionaryModel extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "code", nullable = false, updatable = false)
    private String code;

    public String Name() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}