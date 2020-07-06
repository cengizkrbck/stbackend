package com.cengiz.study.configuration;



import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;


import io.swagger.annotations.ApiModel;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration
 *
 * @author Cengiz Karabacak
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${app.name}")
    String appName;

    @Value("${api.context.url}")
    String apiContextUrl;

    @Value("${app.url}")
    String appUrl;

    @Value("${api.version}")
    String apiVersion;

    @Value("${api.document.description}")
    String apiDocumentDescription;

    @Value("${app.developer.name}")
    String appDeveloperName;

    @Value("${app.developer.mail}")
    String appDeveloperMail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.regex(apiContextUrl + "*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title(appName)
                .description(apiDocumentDescription)
                .version(apiVersion)
                .licenseUrl(appUrl + "LICENSE")
                .contact(new Contact(appDeveloperName, appUrl, appDeveloperMail))
                .build();

    }

}
