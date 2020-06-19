package pl.brewit.brew.dictionary.entity;

import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "units", schema = "\"dictionaries\"")
public class UnitsDictionary extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    public UnitsDictionary() {

    }

    public UnitsDictionary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


