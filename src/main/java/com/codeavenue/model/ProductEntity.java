package com.codeavenue.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Principal product model entity
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/23/16
 */
@Entity
public class ProductEntity implements Serializable {

  private static final long serialVersionUID = -2699979445028159628L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  private String name;
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent")
  private ProductEntity parentProductId;

  @OneToMany(mappedBy = "productEntity")
  private List<ImageEntity> image;

  public ProductEntity() {}

  public ProductEntity(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductEntity getParentProductId() {
    return parentProductId;
  }

  public void setParentProductId(ProductEntity parentProductId) {
    this.parentProductId = parentProductId;
  }

  public List<ImageEntity> getImage() {
    return image;
  }

  public void setImage(List<ImageEntity> image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "ProductEntity{" +
        "productId=" + productId +
        ", name='" + name + '\'' +
        '}';
  }
}
