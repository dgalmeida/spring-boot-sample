package com.codeavenue;

import com.codeavenue.model.ProductEntity;
import com.codeavenue.persistence.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * #description#
 *
 * @author <a href="mailto:diegogr@ciandt.com">Diego G. R. Almeida</a>
 * @since 9/23/16
 */
@SpringBootApplication
public class DemoApplication {

  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(ProductRepository repository) {
    return (args) -> {


      // create and save Products
      repository.save(new ProductEntity("bag", "beautiful bag"));
      repository.save(new ProductEntity("shoes", "beautiful shoes"));
      repository.save(new ProductEntity("book", "beautiful book"));
      repository.save(new ProductEntity("dvd", "beautiful dvd"));
      repository.save(new ProductEntity("microwave", "beautiful microwave"));

      // fetch all products
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (ProductEntity customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual product by ID
      ProductEntity product = repository.findOne(1L);
      log.info("Product found with findOne(1L):");
      log.info("--------------------------------");
      log.info(product.toString());
      log.info("");
    };
  }
}
