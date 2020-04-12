package pl.brewit.brews.domain;

import pl.brewit.common.repository.BaseEntity;
import pl.brewit.dictionary.domain.CountriesDictionaryModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "product")
public class ProductModel extends BaseEntity {

    @Column(name = "rankingValue", nullable = false, updatable = false)
    private byte rankingValue;

    @Column(name = "comment", length = 25500)
    private String comment;

    // Brew - User | Many - One
    @Column(name = "userId")
    private int userId;

    @OneToOne
    @JoinColumn(name = "countriesDictionaryId")
    private CountriesDictionaryModel country;

    public byte getRankingValue() { return rankingValue; }
    public void setRankingValue(byte rankingValue) { this.rankingValue = rankingValue; }

    public String getComment() { return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public CountriesDictionaryModel getCountry() { return country; }
    public void setCountry(CountriesDictionaryModel country) { this.country = country; }
}
