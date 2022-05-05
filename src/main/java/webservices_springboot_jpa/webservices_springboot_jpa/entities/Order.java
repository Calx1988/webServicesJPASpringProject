package webservices_springboot_jpa.webservices_springboot_jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbOrder")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone= "GMT")
    private Instant moment;
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User customer) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus!=null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
