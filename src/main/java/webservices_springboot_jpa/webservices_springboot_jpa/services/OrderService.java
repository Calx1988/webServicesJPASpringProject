package webservices_springboot_jpa.webservices_springboot_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Order;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.User;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.OrderRepository;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.get();
    }
}
