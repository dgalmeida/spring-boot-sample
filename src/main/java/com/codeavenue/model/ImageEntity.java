package com.codeavenue.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * image model entity
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

  private String type;

  @ManyToOne
  @JoinColumn(name = "productEntity")
  private ProductEntity productEntity;

  public ImageEntity() {}

  public ImageEntity(String type, ProductEntity productEntity) {
    this.type = type;
    this.productEntity = productEntity;
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProductEntity getProductEntity() {
    return productEntity;
  }

  public void setProductEntity(ProductEntity productEntity) {
    this.productEntity = productEntity;
  }
}
