package com.bridgelabz.cart.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartID;

    private Integer userID;

    private Integer bookID;
    private Integer quantity;

    public Cart(Integer cartID,Integer quantity, Integer bookID, Integer userID) {
        super();
        this.cartID= cartID;
        this.quantity = quantity;
        this.bookID=bookID;
        this.userID=userID;
    }
    public Cart(Integer quantity, Integer book, Integer user) {
        super();
        this.quantity = quantity;
        this.bookID=book;
        this.userID=user;
    }
    public Cart() {
        super();
    }
}
