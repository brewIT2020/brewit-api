package pl.brewit.brew.entity;

import org.hibernate.annotations.Cascade;
import pl.brewit.brew.dictionary.entity.BrewingToolsDictionary;
import pl.brewit.common.repository.BaseEntity;
import pl.brewit.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "brew", schema = "\"brews\"")
public class Brew extends BaseEntity {

  @Column(name = "brew_date", nullable = false)
  private LocalDate brewDate;

  @Column(name = "description", length = 25500)
  private String description;

  @Column(name = "is_public", nullable = false)
  private boolean isPublic;

  @ManyToOne
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_user"))
  private User user;

  @ManyToOne
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  @JoinColumn(
      name = "product_id",
      nullable = false,
      foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_product"))
  private Product product;

  @ManyToOne
  @JoinColumn(
      name = "brewing_tool_id",
      foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_brewing_tool"))
  private BrewingToolsDictionary brewingTool;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  @JoinColumn(
      name = "brew_id",
      foreignKey = @javax.persistence.ForeignKey(name = "fk_product_parameters_brew"))
  private Set<ProductParameter> productParameters;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  @JoinColumn(
      name = "brew_id",
      foreignKey = @javax.persistence.ForeignKey(name = "fk_rankings_brew"))
  private Set<Ranking> rankings;

  public Brew() {}

  public Brew(
      LocalDate brewDate,
      String description,
      boolean isPublic,
      User user,
      Product product,
      BrewingToolsDictionary brewingTool) {
    this.brewDate = brewDate;
    this.description = description;
    this.isPublic = isPublic;
    this.user = user;
    this.product = product;
    this.brewingTool = brewingTool;
  }

  public LocalDate getBrewDate() {
    return brewDate;
  }

  public void setBrewDate(LocalDate brewDate) {
    this.brewDate = brewDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public BrewingToolsDictionary getBrewingTool() {
    return brewingTool;
  }

  public void setBrewingTool(BrewingToolsDictionary brewingTool) {
    this.brewingTool = brewingTool;
  }

  public Set<Ranking> getRankings() {
    return rankings;
  }

  public void setRankings(Set<Ranking> rankings) {
    this.rankings = rankings;
  }
}
