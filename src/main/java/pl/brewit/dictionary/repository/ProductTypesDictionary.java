package pl.brewit.dictionary.repository;

import pl.brewit.brews.repository.Product;
import pl.brewit.brews.repository.ProductParameter;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_types", schema = "\"dictionaries\"")
public class ProductTypesDictionary extends BaseEntity {

    @Column(name = "typeName", nullable = false)
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productTypesDictionaryId")
    private Set<ProductParameter> productParameters;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productTypesDictionaryId")
    private Set<Product> products;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productTypesDictionaryId")
    private Set<BrewingToolsDictionary> brewingTools;

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public Set<ProductParameter> getProductParameters() { return productParameters; }
    private void setProductParameters(Set<ProductParameter> productParameters) { this.productParameters = productParameters; }

    public Set<Product> getProducts() { return products; }
    private void setProducts(Set<Product> products) { this.products = products; }

    public Set<BrewingToolsDictionary> getBrewingTools() { return brewingTools; }
    private void setBrewingTools(Set<BrewingToolsDictionary> brewingTools) { this.brewingTools = brewingTools; }
}