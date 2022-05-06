package webservices_springboot_jpa.webservices_springboot_jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.*;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.enums.OrderStatus;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.*;

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

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Games");
        Category c4 = new Category(null,"Sports");

        Product p1 = new Product(null, "Lord of The Rings - Deluxe",
                "Fantasy written by J.R.R Tolkien",
                439.90,
                "Aragorn holding sword");
        p1.getCategories().add(c2);
        Product p2 = new Product(null, "The Witcher 3",
                "Fantasy game by CD Projekt Red",
                29.90,
                "Geralt fighting");
        p2.getCategories().add(c3);
        Product p3 = new Product(null, "Iphone Charger",
                "Charger for IPhone 10",
                89.90,
                "Charging phone");
        p3.getCategories().add(c1);
        Product p4 = new Product(null, "Dungeons & Dragons: Tasha’s Cauldron of Everything",
                "Book by Wizards RPG",
                219.00,
                "Mage casting spell");
        p4.getCategories().add(c2);
        Product p5 = new Product(null, "Days Gone",
                "Post apocalyptic game by Bend Studio",
                79.90,
                "Deacon St. John with his bike");
        p5.getCategories().add(c3);
        Product p6 = new Product(null, "Tennis Ball Professional",
                "Package with 3 tennis balls Wilson",
                19.90,
                "Tennis balls being hit");
        p6.getCategories().add(c4);

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3, c4));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5, p6));

        User u1 = new User(null, "Cássio Corrêa",
                "cassio@gmail.com", "51998784553", "cassio");
        User u2 = new User(null, "Maria Bresnici",
                "maria@gmail.com", "51988778654", "maria");
        User u3 = new User(null, "Samantha Weber",
                "samantha@gmail.com", "51985678765", "samantha");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u3);


        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


        OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p6, 3, p6.getPrice());
        OrderItem oi3 = new OrderItem(o2, p2, 1, p2.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
