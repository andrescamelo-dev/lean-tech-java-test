package com.lean.tech.java.Employees.config;

import static springfox.documentation.builders.PathSelectors.regex;

import com.lean.tech.java.Employees.LeanTechJavaTestApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  
   @Bean
      public Docket productApi() {
          return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.lean.tech.java.Employees.controller"))
               .paths(regex(LeanTechJavaTestApplication.PATH_SERVICE+".*"))
               .build().apiInfo(apiEndPointsInfo());
      }
            
   private ApiInfo apiEndPointsInfo() {
       return new ApiInfoBuilder().title("Employee API")
           .description(" CRUD employees  - REST API")
           .contact(new Contact("Andres Camelo M", "https://www.google.com/", "andres.camelo.developer@gmail.com"))
           .license("Apache 2.0")
           .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
           .version("1.0.0")
           .build();
   }
   
}