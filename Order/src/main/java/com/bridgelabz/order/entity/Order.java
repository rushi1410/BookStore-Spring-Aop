package com.bridgelabz.order.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
//Order Model with fields
@Entity
@Data
@Table(name="OrderDetails")
public class Order {
    @Id
    @GeneratedValue
    private Integer orderID;

    private LocalDate date = LocalDate.now();
    private Integer price;
    private Integer quantity;
    private String address;

    private Integer userID;
    private Integer bookID;
    private boolean cancel;

    public Order(Integer orderID,Integer price, Integer quantity, String address, Integer bookID,Integer userID, boolean cancel) {
        this.orderID = orderID;
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.bookID = bookID;
        this.userID=userID;
        this.cancel = cancel;
    }

    public Order() {
        super();
    }

    public Order(Integer price, Integer quantity, String address, Integer bookID, Integer userID, boolean cancel) {
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.bookID = bookID;
        this.userID=userID;
        this.cancel = cancel;
    }

}
