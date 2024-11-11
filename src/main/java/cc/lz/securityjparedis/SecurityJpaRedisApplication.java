package cc.lz.securityjparedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableCaching
public class SecurityJpaRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJpaRedisApplication.class, args);
    }

}
