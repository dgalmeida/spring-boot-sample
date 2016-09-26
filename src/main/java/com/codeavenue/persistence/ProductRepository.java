package com.codeavenue.persistence;

import com.codeavenue.model.ProductEntity;
import com.codeavenue.model.dtos.ProductOnlyDto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Default interface to Spring Data fetch the H2 database
 *
 * @author Diego G. R. Almeida
 * @since 9/23/16
 */
// @RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository
    extends JpaRepository<ProductEntity, Long> {

  /**
   * find all Products information only
   *
   * @return List of ProductsOnlyDto
   */
  List<ProductOnlyDto> findAllProductsOnly();

  /**
   * find specific Product information only
   *
   * @return List of ProductsOnlyDto
   */
  ProductOnlyDto findProductOnly(Long productId);


  /**
   * find list of child products from parent
   *
   * @return List of ProductsOnlyDto
   */
  List<ProductEntity> findChildProducts(Long parentProductId);
}
