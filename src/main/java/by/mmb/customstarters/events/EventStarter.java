package by.mmb.customstarters.events;

import by.mmb.customstarters.properties.StarterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Обрабатываем различные состояния системы
 *
 * @author andrew.maksimovich
 */
@Component
@Slf4j
public class EventStarter {

    private final StarterProperties starterProperties;

    @Autowired
    public EventStarter(StarterProperties starterProperties) {
        this.starterProperties = starterProperties;
    }


    /**
     * Когда приложение поднимется оповестим что стартер удачно подключен
     */
    @EventListener(value = ContextRefreshedEvent.class)
    public void initStarter() {
        log.info(String.format("%s is starting successfully", starterProperties.getNameStarter()));
    }
}
