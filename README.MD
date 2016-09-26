# Rest API CodeAvenue Demo

This example was created using [Spring Boot](http://projects.spring.io/spring-boot/), more especifically:
	-spring-boot-starter-data-jpa (JPA implementation)
	-spring-boot-starter-data-rest (only some runtime exceptions)
	-com.h2database (H2 as in-memory database)
	-spring-boot-starter-test (spring-boot context, junit and hamcrest)
	-springfox-swagger2 and springfox-swagger-ui (as interative UI to the API)
	-spring-boot-maven-plugin (as plugin to help start the application)
	-Tomcat Embedded (as servlet container)


## Some fake data is created with CommandLineRunner spring helper when start the application
	-To access the database(h2-console): http://localhost:8080/h2-console/
	
	-Config
		![Alt config h2](https://drive.google.com/open?id=0B80eRYIyDyLOWXZRcHB3QnlnQmM)
	-Data
		![Alt data](https://drive.google.com/open?id=0B80eRYIyDyLOQTEzTE5LMERqMXc)

# Running:

##Requirements: *JAVA 8+, Maven 3+*
	
### In the root app folder using the terminal (console):
	 	
	mvn spring-boot:run

### To run the suit of tests:
	
	mvn test

# USING 
##To interact and Test by UI with swagger doc:
	As a complement we can use the API by Swagger UI aftar start the app:
		http://localhost:8080/swagger-ui.html#/product-controller



Disclaimer:
	-Spring helps a lot with curd repository code (JpaRepository).
	-The application is not a RESTful complete app using HATEOAS and Hypermedia.(too much in my point of view).
	-The suit of test is just integration tests using spring-mock-mvn to perform the api and match the results.
	-Security was not considered (out of scope).
	-No perfect package organization and well defined interfaces (to much for demo)
