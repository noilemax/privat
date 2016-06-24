package taskivanitsyarest;

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner createDefaultData(UserRepository userRepository) {
//        return (args) -> {
//
//            Set<User> userSet = new HashSet<>();
//
//            userSet.add(new User("Vasya", "qwerty123", (byte) 1));
//            userSet.add(new User("Petya", "qwerty123", (byte) 1));
//            userSet.add(new User("Slava", "qwerty123", (byte) 1));
//            userSet.add(new User("Masha", "qwerty123", (byte) 1));
//            userSet.add(new User("Sam", "qwerty123", (byte) 0));
//
////            userRepository.save(userSet);       // TODO: 24.06.2016
//
//        };
//    }
}

