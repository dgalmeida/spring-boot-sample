package com.springexample;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.springexample.model.ProductEntity;
import com.springexample.model.dtos.ProductOnlyDto;
import com.springexample.persistence.ProductRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ProductRepository repository;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testListAllProductsResults() throws Exception {
    int count = (int) repository.count();

    this.mvc.perform(get("/product/listAll").accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(count)));
  }

  @Test
  public void testListAllCompleteProductsResults() throws Exception {
    int count = (int) repository.count();

    this.mvc.perform(get("/product/listAllComplete").accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(count)))
        .andExpect(jsonPath("$.[2].parentProduct", is(notNullValue())));
  }

  @Test
  public void testFindSpecificCompleteProduct() throws Exception {
    int firstElement = 0;
    ProductEntity product = repository.findAll().get(firstElement);

    this.mvc
        .perform(get("/product/" + product.getProductId()).accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", equalTo("parent product")));
  }

  @Test
  public void testFindSpecificNoCompleteProduct() throws Exception {
    int firstElement = 0;
    ProductOnlyDto product = repository.findAllProductsOnly().get(firstElement);

    thrown.expect(AssertionError.class);
    thrown.expectMessage(containsString("No value at JSON path"));

    this.mvc
        .perform(
            get("/product/" + product.getProductId()).accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", equalTo("parent product")))
        .andExpect(jsonPath("$.parentProduct", is(nullValue())));
  }

  @Test
  public void testSearchToNonExistentProduct() throws Exception {
    this.mvc
        .perform(get("/product/" + 9999999).accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound());
  }

  @Test
  public void testSearchToNonExistentCompleteProduct() throws Exception {
    this.mvc
        .perform(get("/product/" + 9999 + "/complete").accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound());
  }

  @Test
  public void testFindProductsByParent() throws Exception {
    ProductEntity parent = null;

    for (ProductEntity parentProduct : repository.findAll()) {
      if (parentProduct.getParentProduct() != null) {
        parent = parentProduct.getParentProduct();
        break;
      }
    }

    if (parent == null) {
      throw new AssertionError("There is no products with parent on database");
    }

    int count = repository.findChildProducts(parent.getProductId()).size();

    this.mvc
        .perform(
            get("/product/" + parent.getProductId() + "/children")
                .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(count)));
  }


  @Test
  public void testFindImagesByProduct() throws Exception {
    long elementWith2Images = 4L;
    ProductEntity product = repository.findOne(elementWith2Images);

    this.mvc
        .perform(
            get("/product/" + product.getProductId() + "/images")
                .accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$.[0].type", equalTo("jpg1080x780")));
  }
}
