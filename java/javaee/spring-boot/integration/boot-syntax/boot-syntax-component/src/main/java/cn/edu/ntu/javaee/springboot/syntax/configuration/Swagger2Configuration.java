package cn.edu.ntu.javaee.springboot.syntax.configuration;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * config swagger for API. Uri: http://localhost:8080/swagger-ui.html
 *
 * @author zack
 * @create 2019-12-22 19:27
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Document")
                .description("API Document Description")
                .contact(
                        new Contact(
                                "Alice52",
                                "https://github.com/Alice52/demo-code/",
                                "zzhang_xz@163.com"))
                .termsOfServiceUrl("https://github.com/Alice52/java-ocean/")
                .version("1.0")
                .build();
    }
}
