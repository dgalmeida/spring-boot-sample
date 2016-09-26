package com.codeavenue.persistence;

/**
 * #description#
 *
 * @author Diego G. R. Almeida
 * @since 9/26/16
 */
public final class CustomNamedQueries {

  public static final String FIND_ALL_PRODUCT_ONLY_CUSTOM_NAME =
      "ProductEntity.findAllProductsOnly";

  public static final String FIND_ALL_PRODUCT_ONLY_CUSTOM_QUERY =
      "SELECT new " +
          "com.codeavenue.model.dtos.ProductOnlyDto(p.productId, p.name, p.description) " +
          "FROM ProductEntity p";

  public static final String FIND_ONE_PRODUCT_ONLY_CUSTOM_NAME =
      "ProductEntity.findProductOnly";

  public static final String FIND_ONE_PRODUCT_ONLY_CUSTOM_QUERY =
      "SELECT new " +
          "com.codeavenue.model.dtos.ProductOnlyDto(p.productId, p.name, p.description) " +
          "FROM ProductEntity p WHERE p.productId = ?1";

  public static final String FIND_CHILD_PRODUCTS_NAME = "ProductEntity.findChildProducts";

  public static final String FIND_CHILD_PRODUCTS_QUERY =
      "SELECT p from ProductEntity p WHERE p.parentProduct.id = ?1";
}
