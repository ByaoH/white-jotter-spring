package com.l.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * swagger 配置类
 *
 * @author l
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {
        boolean b = environment.acceptsProfiles(Profiles.of("dev"));
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(b)
                .groupName("ByaoH")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    private ApiInfo apiInfo() {
//        作者信息
        Contact contact = new Contact(
                "ByaoH",
                "https://byaoh.coding.net/public/",
                "ll789y@gmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "L7-BAG-Swagger",
                "学习swagger",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
