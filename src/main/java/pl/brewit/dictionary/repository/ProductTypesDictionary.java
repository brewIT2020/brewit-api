package pl.brewit.dictionary.repository;

import pl.brewit.brews.repository.dao.Product;
import pl.brewit.brews.repository.dao.ProductParameter;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_types", schema = "\"dictionaries\"")
public class ProductTypesDictionary extends BaseEntity {

    @Column(name = "type_name", nullable = false)
    private String typeName;

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}