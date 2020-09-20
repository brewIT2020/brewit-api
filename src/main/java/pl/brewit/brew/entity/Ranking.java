package pl.brewit.brew.entity;

import pl.brewit.common.repository.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ranking", schema = "\"brews\"")
public class Ranking extends BaseEntity {

  @Column(name = "ranking_value", nullable = false)
  private byte rankingValue;

  @Column(name = "comment", length = 25500)
  private String comment;

  public Ranking() {}

  public Ranking(byte rankingValue, String comment) {
    this.rankingValue = rankingValue;
    this.comment = comment;
  }

  public byte getRankingValue() {
    return rankingValue;
  }

  public void setRankingValue(byte rankingValue) {
    this.rankingValue = rankingValue;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
