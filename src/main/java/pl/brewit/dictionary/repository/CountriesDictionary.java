package pl.brewit.dictionary.repository;

import pl.brewit.brews.repository.dao.Product;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries", schema = "\"dictionaries\"")
public class CountriesDictionary extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    public CountriesDictionary(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}