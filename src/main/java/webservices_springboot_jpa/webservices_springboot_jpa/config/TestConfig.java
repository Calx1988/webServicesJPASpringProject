package webservices_springboot_jpa.webservices_springboot_jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Category;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Order;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Product;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.User;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.enums.OrderStatus;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.CategoryRepository;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.OrderRepository;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.ProductRepository;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.UserRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown",
                "maria@gmail.com", "51998784553", "maria");
        User u2 = new User(null, "Alex Green",
                "alex@gmail.com", "11988778654", "alex");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Games");

        Product p1 = new Product(null, "Lord of The Rings - Deluxe",
                "Fantasy written by J.R.R Tolkien",
                439.90,
                "Aragorn holding sword");
        Product p2 = new Product(null, "The Witcher 3",
                "Fantasy game by CD Projekt Red",
                29.90,
                "Geralt fighting");
        Product p3 = new Product(null, "Iphone Charger",
                "Charger for IPhone 10",
                89.90,
                "Charging phone");
        Product p4 = new Product(null, "Dungeons & Dragons: Tasha’s Cauldron of Everything",
                "Book by Wizards RPG",
                219.00,
                "Mage casting spell");
        Product p5 = new Product(null, "Days Gone",
                "Post apocalyptic game by Bend Studio",
                79.90,
                "Deacon St. John with his bike");


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
