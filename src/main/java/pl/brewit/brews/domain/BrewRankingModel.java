package pl.brewit.brews.domain;

import java.sql.Date;
import javax.persistence.*;
import pl.brewit.common.repository.BaseEntity;

@Entity(name = "brewRanking")
public class BrewRankingModel extends BaseEntity {

    @Column(name = "rankingValue", nullable = false, updatable = false)
    private byte rankingValue;

    @Column(name = "comment", length = 25500)
    private String comment;

    // User BrewRanking | One Many
    @Column(name = "userId")
    private int userId;

    @ManyToOne
    private BrewModel brew;


    public byte getRankingValue() { return rankingValue; }
    public void setRankingValue(byte rankingValue) { this.rankingValue = rankingValue; }

    public String getComment() { return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public BrewModel getBrew() { return brew; }
    public void setBrew(BrewModel brew) { this.brew = brew; }
}
