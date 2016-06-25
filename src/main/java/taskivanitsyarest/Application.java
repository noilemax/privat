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

            userRepository.save(new User("Vasya", "qwe23", (byte) 1));
            userRepository.save(new User("Some Guy", "123", (byte) 1));
            userRepository.save(new User("Ivan", "qwedfg23", (byte) 1));
            userRepository.save(new User("Vasya4", "qwerty321", (byte) 1));
            userRepository.save(new User("Qwerty", "qbnmfgy3", (byte) 1));

            log.info("\n");
            log.info("--findAll-----------------------------");
            for (User user1 : userRepository.findAll()) {
                log.info("ID: "+user1.getId().toString() + "  USERNAME: "+user1.getUsername().toString() + "  USER_PASSSWORD: " + user1.getPassword().toString());
            }
            log.info("-------------------------------");

            log.info("\n");
            log.info("--findOne (2user)-----------------------------");
            log.info("ID: " + userRepository.findOne(2L).getId().toString()
                    + "  NAME: " + userRepository.findOne(2L).getUsername().toString()
                    + "  PASSWORD: " + userRepository.findOne(2L).getPassword().toString()
                    + "  ISaCTIV: " + userRepository.findOne(2L).getIsactive().toString());
            log.info("-------------------------------");

            userRepository.delete(3L);

            log.info("\n");
            log.info("--deleteOne (3user)-----------------------------");
            for (User user1 : userRepository.findAll()) {
                log.info("ID: "+user1.getId().toString() + "  USERNAME: "+user1.getUsername().toString() + "  USER_PASSSWORD: " + user1.getPassword().toString());
            }
            log.info("-------------------------------");

            userRepository.save(new User("New User", "newpass", (byte) 1));

            log.info("\n");
            log.info("--findAll-----------------------------");
            for (User user1 : userRepository.findAll()) {
                log.info("ID: "+user1.getId().toString() + "  USERNAME: "+user1.getUsername().toString() + "  USER_PASSSWORD: " + user1.getPassword().toString());
            }
            log.info("-------------------------------");
        };
    }
}

