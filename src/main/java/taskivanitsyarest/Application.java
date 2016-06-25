package taskivanitsyarest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import taskivanitsyarest.dao.entity.User;
import taskivanitsyarest.dao.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableWebMvc
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createDefaultData(UserRepository userRepository) {
        return (args) -> {

            userRepository.save(new User("Vasya", "qwerty123", (byte) 1));
            userRepository.save(new User("Some Guy", "qwerty123", (byte) 1));
            userRepository.save(new User("Ivan", "qwerty123", (byte) 1));
            userRepository.save(new User("Vasya4", "qwerty123", (byte) 1));
            userRepository.save(new User("Qwerty", "qwerty123", (byte) 1));


            log.info("LunchMenu findAll():");
            log.info("-------------------------------");
            for (User user1 : userRepository.findAll()) {
                log.info(user1.toString());
            }
            log.info("-------------------------------");

        };
    }
}

