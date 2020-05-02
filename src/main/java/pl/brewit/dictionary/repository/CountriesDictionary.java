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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    private Set<Product> products;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Set<Product> getProducts() { return products; }
    private void setProducts(Set<Product> products) { this.products = products; }
}