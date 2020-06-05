package pl.brewit.dictionary.repository;

import pl.brewit.brews.repository.dao.Brew;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brewing_tools", schema = "\"dictionaries\"")
public class BrewingToolsDictionary extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    public BrewingToolsDictionary(String name, ProductTypesDictionary productType) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


