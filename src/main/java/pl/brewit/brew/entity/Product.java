package pl.brewit.brew.entity;

import org.hibernate.annotations.Cascade;
import pl.brewit.brew.dictionary.entity.CountriesDictionary;
import pl.brewit.brew.dictionary.entity.ProductTypesDictionary;
import pl.brewit.common.repository.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product", schema = "\"brews\"")
public class Product extends BaseEntity {

  @Column(name = "product_name")
  private String productName;

  @Column(name = "is_template")
  private boolean isTemplate;

  @ManyToOne
  @JoinColumn(
      name = "country_id",
      foreignKey = @javax.persistence.ForeignKey(name = "fk_products_country"))
  private CountriesDictionary country;

  @ManyToOne
  @JoinColumn(
      name = "product_type_id",
      nullable = false,
      foreignKey = @javax.persistence.ForeignKey(name = "fk_products_product_type"))
  private ProductTypesDictionary productType;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  @JoinColumn(
      name = "product_id",
      foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_product"))
  private Set<ProductParameter> productParameterValues;

  public Product() {}

  public Product(
      String productName,
      boolean isTemplate,
      CountriesDictionary country,
      ProductTypesDictionary productType,
      Set<ProductParameter> productParameterValues) {
    this.productName = productName;
    this.isTemplate = isTemplate;
    this.country = country;
    this.productType = productType;
    this.productParameterValues = productParameterValues;
  }

  public boolean isTemplate() {
    return isTemplate;
  }

  public void setTemplate(boolean template) {
    isTemplate = template;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public CountriesDictionary getCountry() {
    return country;
  }

  public void setCountry(CountriesDictionary country) {
    this.country = country;
  }

  public ProductTypesDictionary getProductType() {
    return productType;
  }

  public void setProductType(ProductTypesDictionary productType) {
    this.productType = productType;
  }

  public Set<ProductParameter> getProductParameterValues() {
    return productParameterValues;
  }

  public void setProductParameterValues(Set<ProductParameter> productParameterValues) {
    this.productParameterValues = productParameterValues;
  }
}
