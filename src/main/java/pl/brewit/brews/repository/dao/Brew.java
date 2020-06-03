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

    @Column(name = "description", length = 25500)
    private String description;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_user"))
    private User user;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brewing_tool_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_brews_brewing_tool"))
    private BrewingToolsDictionary brewingTool;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "brew_id",
            foreignKey = @javax.persistence.ForeignKey(name = "fk_rankings_brew"))
    private Set<BrewRanking> rankings;

    public Brew(LocalDate brewDate, String description, boolean isPublic, User user, Product product, BrewingToolsDictionary brewingTool) {
        this.brewDate = brewDate;
        this.description = description;
        this.isPublic = isPublic;
        this.user = user;
        this.product = product;
        this.brewingTool = brewingTool;
    }
}
