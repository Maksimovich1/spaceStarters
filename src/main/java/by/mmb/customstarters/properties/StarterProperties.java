package by.mmb.customstarters.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Кастомные настройки для управления стартером
 *
 * @author andrew.maksimovich
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "starter.custom")
public class StarterProperties {

    private String nameStarter = "Common starters";
    private String pathControllers = "by.mmb.controllers";

    private String apiTitle = "Application";
    private String apiDescription = "";
    private String version = "";
    private String apiTerm = "";
    private String apiLicense = "";
    private String apiLicenseUrl = "";

    private String apiContactName = "";
    private String apiContactSite = "";
    private String apiContactEmail = "";

}
