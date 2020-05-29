package pl.brewit.brews.repository.dao;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.repository.BrewingToolsDictionary;
import pl.brewit.user.User;

@Entity
@Table(name = "brew", schema = "\"brews\"")
public class Brew extends BaseEntity {

    @Column(name = "brew_date", nullable = false)
    private LocalDate brewDate;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_user_brew"))
    private User user;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_product_brew"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brewing_tool_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brewing_tool_brew"))
    private BrewingToolsDictionary brewingTool;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "brew_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brew_ranking"))
    private Set<BrewRanking> rankings;

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public LocalDate getBrewDate() {
        return brewDate;
    }

    public void setBrewDate(LocalDate date) {
        this.brewDate = date;
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

    public Set<BrewRanking> getRankings() {
        return rankings;
    }

    public void setRankings(Set<BrewRanking> rankings) {
        this.rankings = rankings;
    }
}
