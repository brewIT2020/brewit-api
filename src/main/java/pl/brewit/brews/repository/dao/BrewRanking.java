package pl.brewit.brews.repository.dao;

import javax.persistence.*;

import pl.brewit.brews.repository.dao.Brew;
import pl.brewit.common.repository.BaseEntity;
import pl.brewit.user.User;

@Entity
@Table(name = "ranking", schema = "\"brews\"")
public class BrewRanking extends BaseEntity {

    @Column(name = "ranking_value", nullable = false)
    private byte rankingValue;

    @Column(name = "comment", length = 25500)
    private String comment;

    public byte getRankingValue() { return rankingValue; }
    public void setRankingValue(byte rankingValue) { this.rankingValue = rankingValue; }

    public String getComment() { return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
