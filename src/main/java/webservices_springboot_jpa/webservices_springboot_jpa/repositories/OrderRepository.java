package webservices_springboot_jpa.webservices_springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
