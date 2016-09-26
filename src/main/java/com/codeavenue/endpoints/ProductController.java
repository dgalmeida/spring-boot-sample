package com.codeavenue.endpoints;

import com.codeavenue.model.ImageEntity;
import com.codeavenue.model.ProductEntity;
import com.codeavenue.model.dtos.ProductOnlyDto;
import com.codeavenue.persistence.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring REST controller to the Product
 *
 * @author Diego G. R. Almeida
 * @since 9/26/16
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=UTF-8";

  @Autowired
  private ProductRepository repository;

  /**
   * Get all products excluding relationships (child products, images)
   *
   * @return list of Product without relationships
   */
  @RequestMapping(
      value = "/listAll",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public List<ProductOnlyDto> findAllProductsOnly() {
    return repository.findAllProductsOnly();
  }

  /**
   * Get all products including relationships (child products, images)
   *
   * @return list of Product with relationships
   */
  @RequestMapping(
      value = "/listAllComplete",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public List<ProductEntity> findAllProductsComplete() {
    return repository.findAll();
  }

  /**
   * Get specific product excluding relationships (child products, images)
   *
   * @param productId specific product identification
   */
  @RequestMapping(
      value = "/{productId}",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public ProductOnlyDto findProduct(@PathVariable Long productId) {
    ProductOnlyDto productOnly = repository.findProductOnly(productId);

    if (productOnly == null) {
      throw new ResourceNotFoundException();
    }

    return productOnly;
  }

  /**
   * Get specific product with relationships (child products, images)
   *
   * @param productId specific product identification
   */
  @RequestMapping(
      value = "/{productId}/complete",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public ProductEntity findProductComplete(@PathVariable Long productId) {
    ProductEntity productEntity = repository.findOne(productId);

    if (productEntity == null) {
      throw new ResourceNotFoundException();
    }


    return productEntity;
  }

  /**
   * Get specific child list of products from parentId
   *
   * @param parentProductId specific parent product identification
   */
  @RequestMapping(
      value = "/{parentProductId}/children",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public List<ProductEntity> findChildProducts(@PathVariable Long parentProductId) {
    List<ProductEntity> childProducts = repository.findChildProducts(parentProductId);

    if (childProducts.isEmpty()) {
      throw new ResourceNotFoundException(
          "There is no products to this Parent Product id(" + parentProductId + ")");
    }

    return childProducts;
  }


  /**
   * Get specific product with relationships (child products, images)
   *
   * @param productId specific product identification
   */
  @RequestMapping(
      value = "/{productId}/images",
      method = RequestMethod.GET,
      produces = APPLICATION_JSON_CHARSET_UTF_8)
  public List<ImageEntity> findImagesByProduct(@PathVariable Long productId) {
    ProductEntity productEntity = repository.findOne(productId);

    if (productEntity == null) {
      throw new ResourceNotFoundException();
    }

    return productEntity.getImages();
  }
}
