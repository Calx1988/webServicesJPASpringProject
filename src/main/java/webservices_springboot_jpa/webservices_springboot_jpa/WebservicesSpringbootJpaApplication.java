package webservices_springboot_jpa.webservices_springboot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class WebservicesSpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WebservicesSpringbootJpaApplication.class);
		springApplication.setDefaultProperties(Collections.singletonMap("server.port", "3306"));
		springApplication.run(args);
	}

}
