package pl.brewit.brews.domain;

import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

import pl.brewit.common.repository.BaseEntity;

@Entity(name = "brew")
public class BrewModel extends BaseEntity {

    @Column(name = "brewDate", nullable = false, updatable = false)
    private Date brewDate;

    @Column(name = "isPublic", nullable = false)
    private boolean isPublic;

    // Brew - User | Many - One
    @Column(name = "userId")
    private int userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private ProductModel product;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "brewingToolId")
    private Set<BrewRankingModel> rankings;

    public boolean getIsPublic() { return isPublic; }
    public void setIsPublic(boolean isPublic) { this.isPublic = isPublic; }

    public Date getBrewDate() { return brewDate; }
    public void setBrewDate(Date date) {
        this.brewDate = date;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public ProductModel getProduct() { return product; }
    public void setProduct(ProductModel product) { this.product = product; }

    public Set<BrewRankingModel> getRankings() { return rankings; }
    public void setRankings(Set<BrewRankingModel> rankings) { this.rankings=rankings; }
}
