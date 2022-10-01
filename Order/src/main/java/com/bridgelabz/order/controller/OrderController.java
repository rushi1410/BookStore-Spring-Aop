package com.bridgelabz.order.controller;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.dto.ResponseDTO;
import com.bridgelabz.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Controller to make api calls
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    //Autowired IOrderService dependency to inject its dependency here
    @Autowired
    private IOrderService orderService;

    //Ability to call api to add order record
    //localhost:8084/order/add
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addOrder(@Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Order registered successfully", orderService.addOrder(orderdto));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //Ability to call api get all order records
    //localhost:8084/order/getAllOrders
    @GetMapping("/getAllOrders")
    public ResponseEntity<ResponseDTO> getAllOrderRecords() {
        ResponseDTO dto = new ResponseDTO("All records get successfully", orderService.getAllOrderRecords());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //Ability to call api to get order records by id
    //localhost:8084/order/getOrder/{id}
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record get successfully", orderService.getOrderRecord(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //Ability to call api to update order record by id
    //localhost:8084/order/updateOrder/{id}
    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id, @Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Record updated successfully", orderService.updateOrderRecord(id, orderdto));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }

    //Ability to call api to delete order record by id
    //localhost:8084/order/deleteOrder/{id}
    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<ResponseDTO> deleteOrderRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record deleted successfully", orderService.deleteOrderRecord(id));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
    //Ability to call api to cancel order record by id
    //localhost:8084/order/cancelOrder/{id}
    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<ResponseDTO> cancelOrderRecord(@PathVariable Integer id, @Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Order Record canceled successfully", orderService.cancelOrderRecord(id, orderdto));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }

}
