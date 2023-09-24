package org.dargor.configserver.logger;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EnvironmentPropertiesLogger {

    @EventListener
    public void handleContextRefreshed(ApplicationContextInitializedEvent event) {
        ConfigurableEnvironment env = event.getApplicationContext().getEnvironment();
        log.info("{}={}", "git-user", env.getProperty("spring.cloud.config.server.git.username"));
        log.info("{}={}", "git-pwd", env.getProperty("spring.cloud.config.server.git.password"));
    }

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();
        log.info("{}={}", "git-user", env.getProperty("spring.cloud.config.server.git.username"));
        log.info("{}={}", "git-pwd", env.getProperty("spring.cloud.config.server.git.password"));
    }
}
