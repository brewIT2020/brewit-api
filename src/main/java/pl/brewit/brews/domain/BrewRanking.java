package pl.brewit.brews.domain;

import javax.persistence.*;
import pl.brewit.common.repository.BaseEntity;

@Entity(name = "brewRanking")
public class BrewRanking extends BaseEntity {

    @Column(name = "rankingValue", nullable = false)
    private byte rankingValue;

    @Column(name = "comment", length = 25500)
    private String comment;

    // TBD : User BrewRanking | One Many
    @Column(name = "userId")
    private int userId;

    @ManyToOne
    private Brew brew;

    public byte getRankingValue() { return rankingValue; }
    public void setRankingValue(byte rankingValue) { this.rankingValue = rankingValue; }

    public String getComment() { return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Brew getBrew() { return brew; }
    private void setBrew(Brew brew) { this.brew = brew; }
}
