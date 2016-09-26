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
 * main spring-boot application starter
 *
 * @author Diego G. R. Almeida
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

      ProductEntity bag = new ProductEntity("bag", "beautiful bag");
      bag.addImage("png300x300");
      bag.addImage("jpg1080x780");

      ProductEntity shoes = new ProductEntity("shoes", "beautiful shoes");
      shoes.addImage("gif450x450");

      ProductEntity book = new ProductEntity("book", "beautiful book");
      book.addImage("jpg1080x780");
      book.addImage("png800x600");

      ProductEntity dvd = new ProductEntity("dvd", "beautiful dvd");
      dvd.addImage("jpg1024x786");

      ProductEntity parent = new ProductEntity("parent product", "beautiful parent");
      parent.addImage("png500x500");
      repository.save(parent);


      bag.setParentProduct(parent);
      shoes.setParentProduct(parent);
      book.setParentProduct(parent);
      dvd.setParentProduct(parent);

      // create and save Products
      repository.save(bag);
      repository.save(shoes);
      repository.save(book);
      repository.save(dvd);
    };
  }
}
