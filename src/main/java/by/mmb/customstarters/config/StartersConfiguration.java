package by.mmb.customstarters.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Конфигурация стартеров
 *
 * @author andrew.maksimovich
 */

@Configuration
@Slf4j
@EnableSwagger2
public class StartersConfiguration {

    @Bean
    public String s() {
        log.info("Бин СОЗДАН!!!!!!!!!!!!!!!!!!!!!!");
        return "";
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
