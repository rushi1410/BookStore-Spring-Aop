package com.bridgelabz.springbootrabbitmqbookstore.publisher;

import com.bridgelabz.springbootrabbitmqbookstore.config.MessagingConfig;
import com.bridgelabz.springbootrabbitmqbookstore.dto.Order;
import com.bridgelabz.springbootrabbitmqbookstore.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
    @Autowired
    private RabbitTemplate template;
    @PostMapping("/{add}")
    public String bookOrder(@RequestBody Order order) {
        order.setOrderID(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully ");
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}

