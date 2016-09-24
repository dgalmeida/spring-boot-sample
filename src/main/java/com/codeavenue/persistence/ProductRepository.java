package com.codeavenue.persistence;

import com.codeavenue.model.ProductEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * default interface to Spring Data generate the Restful
 * services at Runtime.
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/23/16
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository
    extends CrudRepository<ProductEntity, Long> {
}
