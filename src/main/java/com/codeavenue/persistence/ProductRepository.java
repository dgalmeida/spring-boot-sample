package com.codeavenue.persistence;

import com.codeavenue.model.ProductEntity;
import com.codeavenue.model.dtos.ProductOnlyDto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Default interface to Spring Data fetch the H2 database
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/23/16
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository
    extends CrudRepository<ProductEntity, Long> {

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
  List<ProductOnlyDto> findProductOnly(Long productId);
}
