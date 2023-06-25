package org.dargor.prompathconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableConfigServer

@SpringBootApplication
public class PromPathConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromPathConfigServerApplication.class, args);
    }

}
