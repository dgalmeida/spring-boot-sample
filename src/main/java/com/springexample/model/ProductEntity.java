package com.springexample.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springexample.persistence.CustomNamedQueries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Principal product model entity
 *
 * @author Diego G. R. Almeida
 * @since 9/23/16
 */
@Entity
@NamedQueries({
    @NamedQuery(name = CustomNamedQueries.FIND_ALL_PRODUCT_ONLY_CUSTOM_NAME,
        query = CustomNamedQueries.FIND_ALL_PRODUCT_ONLY_CUSTOM_QUERY),

    @NamedQuery(name = CustomNamedQueries.FIND_ONE_PRODUCT_ONLY_CUSTOM_NAME,
        query = CustomNamedQueries.FIND_ONE_PRODUCT_ONLY_CUSTOM_QUERY),

    @NamedQuery(name = CustomNamedQueries.FIND_CHILD_PRODUCTS_NAME,
        query = CustomNamedQueries.FIND_CHILD_PRODUCTS_QUERY)
})
public class ProductEntity implements Serializable {

  private static final long serialVersionUID = -2699979445028159628L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  private String name;
  private String description;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent")
  private ProductEntity parentProduct;

  @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<ImageEntity> images;

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

  public ProductEntity getParentProduct() {
    return parentProduct;
  }

  public void setParentProduct(ProductEntity parentProduct) {
    this.parentProduct = parentProduct;
  }

  public List<ImageEntity> getImages() {
    return images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }

  public void addImage(String imageType) {
    ImageEntity image = new ImageEntity(imageType, this);

    if (images != null) {
      this.images.add(image);
      return;
    }

    this.images = new ArrayList<>();
    this.images.add(image);
  }

  @Override
  public String toString() {
    return "ProductEntity{" +
        "productId=" + productId +
        ", name='" + name + '\'' +
        '}';
  }
}
