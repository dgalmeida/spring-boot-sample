package com.codeavenue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger config to spring-boot
 *
 * @author Diego G. R. Almeida
 * @since 9/26/16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/product/.*"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Rest API CodeAvenue Demo")
        .description("Rest app using spring-boot and doc by swagger")
        .version("1.0")
        .termsOfServiceUrl("http://localhost:8080/v2/api-docs")
        .licenseUrl("http://localhost:8080/v2/api-docs")
        .build();
  }

}
