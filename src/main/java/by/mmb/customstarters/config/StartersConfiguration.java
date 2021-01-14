package by.mmb.customstarters.config;

import by.mmb.customstarters.properties.StarterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Конфигурация стартеров
 *
 * @author andrew.maksimovich
 */

@Configuration
@Slf4j
@EnableSwagger2
@EnableConfigurationProperties(StarterProperties.class)
public class StartersConfiguration {

    private final StarterProperties properties;

    @Autowired
    public StartersConfiguration(StarterProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Docket api() {
        log.trace("The bean Docket for Swagger was created!");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getPathControllers()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfo(
                properties.getApiTitle(),
                properties.getApiDescription(),
                properties.getVersion(),
                properties.getApiTerm(),
                new Contact(properties.getApiContactName(), properties.getApiContactSite(), properties.getApiContactEmail()),
                properties.getApiLicense(), properties.getApiLicenseUrl(), Collections.emptyList());
    }
}
