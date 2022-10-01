package com.bridgelabz.order.service;
import java.util.List;
import java.util.Optional;

import com.bridgelabz.order.repository.OrderRepository;
import com.bridgelabz.order.util.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.exception.BookStoreException;
import com.bridgelabz.order.entity.Order;

import lombok.extern.slf4j.Slf4j;

//Ability to provide service to controller
@Service
@Slf4j
public class OrderService implements IOrderService {
    //Autowired to inject dependency here
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    EmailSenderService mailService;


    //Ability to serve controller's add order record api call
    public Order addOrder(OrderDTO orderdto) {

                Order newOrder = new Order(orderdto.getPrice(), orderdto.getQuantity(), orderdto.getAddress(),orderdto.getBookID(),orderdto.getUserID(), orderdto.isCancel());
                orderRepo.save(newOrder);
                mailService.sendEmail(orderdto.getEmail(), "Order Placed Successfully", "Hello,Thank you for placing an " + newOrder + " We’re glad to inform you that we’ve received your order and will process it very soon");
                log.info("Order record add successfully");
                return newOrder;
            }


    //Ability to serve controller's get all order records api call
    public List<Order> getAllOrderRecords() {
        List<Order> orderList = orderRepo.findAll();
        log.info("ALL order records get successfully");
        return orderList;
    }

    //Ability to serve controller's get order record by id api call
    public Order getOrderRecord(Integer id) {
        Optional<Order> order = orderRepo.findById(id);
        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
            log.info("Order record get successfully for id " + id);
            return order.get();
        }
    }

    //Ability to serve controller's update order record by id api call
    public Order updateOrderRecord(Integer id, OrderDTO dto) {
        Optional<Order> order = orderRepo.findById(id);

        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
                    Order newOrder = new Order(id, dto.getPrice(), dto.getQuantity(), dto.getAddress(),dto.getBookID(),dto.getUserID(), dto.isCancel());
                    orderRepo.save(newOrder);
                    log.info("Order record updated successfully for id " + id);
                    return newOrder;
                }
    }

    //Ability to serve controller's delete order record by id api call
    public Order deleteOrderRecord(Integer id) {
        Optional<Order> order = orderRepo.findById(id);

        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
            orderRepo.deleteById(id);
            log.info("Order record deleted successfully for id " + id);
            return order.get();
        }
    }

    //Ability to serve controller's cancel order record by id api call
    public Order cancelOrderRecord(Integer id, OrderDTO dto) {
        Optional<Order> order = orderRepo.findById(id);
        order.get().setCancel(true);
        orderRepo.save(order.get());
        mailService.sendEmail(dto.getEmail(), "Order cancelled Successfully", "Hello,your Order Cancelled Successfully ");
        return order.get();
    }
}
