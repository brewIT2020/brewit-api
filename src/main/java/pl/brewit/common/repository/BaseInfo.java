package pl.brewit.common.repository;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
@Embeddable
public class BaseInfo {

  @Column(name = "active", columnDefinition = "true")
  private Boolean active;

  @Column(name = "createdDate", nullable = false, insertable = true, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column(name = "updatedDate", nullable = true, updatable = true)
  @UpdateTimestamp
  private LocalDateTime updatedDate;

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }
}
