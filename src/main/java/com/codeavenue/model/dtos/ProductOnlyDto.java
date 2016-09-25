package com.codeavenue.model.dtos;

/**
 * dto entity to list only products
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/25/16
 */
public class ProductOnlyDto {

  public static final String FIND_ALL_CUSTOM_NAME =
      "ProductEntity.findAllProductsOnly";

  public static final String FIND_ALL_CUSTOM_QUERY =
      "SELECT new " +
          "com.codeavenue.model.dtos.ProductOnlyDto(p.productId, p.name, p.description) " +
          "FROM ProductEntity p";

  private Long productId;
  private String name;
  private String description;

  public ProductOnlyDto() {}

  public ProductOnlyDto(Long productId, String name, String description) {
    this.productId = productId;
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
}
