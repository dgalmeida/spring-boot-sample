package com.codeavenue.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * #description#
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/23/16
 */
@Entity
public class ImageEntity implements Serializable {

  private static final long serialVersionUID = -2376513726970203539L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long imageId;

  @ManyToOne
  @JoinColumn(name = "productEntity")
  private ProductEntity productEntity;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public ProductEntity getProductEntity() {
    return productEntity;
  }

  public void setProductEntity(ProductEntity productEntity) {
    this.productEntity = productEntity;
  }
}
