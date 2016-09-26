# Rest API Demo

This example was created using [Spring Boot](http://projects.spring.io/spring-boot/), more especifically.

1. spring-boot-starter-data-jpa (JPA implementation)
2. spring-boot-starter-data-rest (only some runtime exceptions)
3. com.h2database (H2 as in-memory database)
4. spring-boot-starter-test (spring-boot context, junit and hamcrest)
5. springfox-swagger2 and springfox-swagger-ui (as interative UI to the API)
6. spring-boot-maven-plugin (as plugin to help start the application)
7. Tomcat Embedded (as servlet container - HTTP server)

# Running:

##Requirements: *JAVA 8+, Maven 3+*
	
### In the root app folder using the terminal (console):
	 	
	mvn spring-boot:run

### To run the suit of tests:
	
	mvn test

# USING 
##To interact and Test by UI with swagger doc
As a complement we can use the API by Swagger UI aftar start the app:

	(http://localhost:8080/swagger-ui.html#/product-controller)


## Some fake data is created when start the application

To access the database (h2-console): 
	(http://localhost:8080/h2-console/)

![Alt config h2](http://s17.postimg.org/sqg09ndtb/Screenshot_from_2016_09_26_14_27_56.png)
![Alt data](http://s17.postimg.org/dgbjopsxb/Screenshot_from_2016_09_26_14_28_26.png)



--------------------------
###Disclaimer
	1.Spring helps a lot with curd repository code (JpaRepository).
	2.The application is not a RESTful complete app using HATEOAS and Hypermedia.(too much in my point of view).
	3.The suit of test is just integration tests using spring-mock-mvn to perform the api and match the results.
	4.Security was not considered (out of scope).
	5.No perfect package organization and well defined interfaces (to much for demo)