package pl.brewit.brews.repository.dao;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.repository.BrewingToolsDictionary;

//DAO
@Entity
@Table(name = "brew", schema = "\"brews\"")
public class Brew extends BaseEntity {

    @Column(name = "brew_date", nullable = false)
    private LocalDate brewDate;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    // TBD : Brew - User | Many - One
    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brewing_tool_id")
    private BrewingToolsDictionary brewingTool;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brew")
    private Set<BrewRanking> rankings;

    public boolean getIsPublic() { return isPublic; }
    public void setIsPublic(boolean isPublic) { this.isPublic = isPublic; }

    public LocalDate getBrewDate() { return brewDate; }
    public void setBrewDate(LocalDate date) {
        this.brewDate = date;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public BrewingToolsDictionary getBrewingTool() { return brewingTool; }
    public void setBrewingTool(BrewingToolsDictionary brewingTool) { this.brewingTool = brewingTool; }

    public Set<BrewRanking> getRankings() { return rankings; }
    public void setRankings(Set<BrewRanking> rankings) { this.rankings = rankings; }
}
