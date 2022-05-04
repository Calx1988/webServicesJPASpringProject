package webservices_springboot_jpa.webservices_springboot_jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.User;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.UserRepository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown",
                "maria@gmail.com", "51998784553", "maria");
        User u2 = new User(null, "Alex Green",
                "alex@gmail.com", "11988778654", "alex");
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
