package webservices_springboot_jpa.webservices_springboot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.util.Collections;
import java.util.Scanner;

@SpringBootApplication
public class WebservicesSpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WebservicesSpringbootJpaApplication.class);
		springApplication.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
		springApplication.run(args);
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

}
