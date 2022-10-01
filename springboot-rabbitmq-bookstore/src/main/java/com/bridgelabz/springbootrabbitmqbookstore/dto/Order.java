package com.bridgelabz.springbootrabbitmqbookstore.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderID;
    private String bookname;
    private int quantity;
    private double price;
    private String address;
    private Integer userID;
    private Integer bookID;
    private boolean cancel;
    private String email;
}

