package com.bridgelabz.cart.service;


import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.entity.Cart;
import com.bridgelabz.cart.exception.BookStoreException;
import com.bridgelabz.cart.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartService implements ICartService {
    //Autowired to inject its dependency here
    @Autowired
    private CartRepository cartRepo;


    //Ability to serve to controller's add cart details api call
    public Cart addCart(CartDTO cartdto) {
        Cart newCart = new Cart(cartdto.getQuantity(),cartdto.getUserID(),cartdto.getBookID());
                cartRepo.save(newCart);
                log.info("Cart record added successfully");

                return newCart;

    }

    //Ability to serve to controller's get all cart records api call
    public List<Cart> getAllCartRecords() {
        List<Cart> cartList = cartRepo.findAll();
        log.info("All cart records retrieved successfully");
        return cartList;
    }

    //Ability to serve to controller's get cart record by id api call
    public Cart getCartRecord(Integer id) {
        Optional<Cart> cart = cartRepo.findById(id);
        if (cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        } else {
            log.info("Cart record retrieved successfully for id " + id);
            return cart.get();
        }
    }

    //Ability to serve to controller's update cart record by id api call
    public Cart updateCartRecord(Integer id, CartDTO dto) {
        Optional<Cart> cart = cartRepo.findById(id);

                    Cart newCart = new Cart(id, dto.getQuantity(), dto.getBookID(),dto.getUserID());
                    cartRepo.save(newCart);
                    log.info("Cart record updated successfully for id " + id);
                    return newCart;
                }


    //Ability to serve to controller's delete cart record by id api call
    public Cart deleteCartRecord(Integer id) {
        Optional<Cart> cart = cartRepo.findById(id);

        if (cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        } else {

            cartRepo.deleteById(id);
            log.info("Cart record deleted successfully for id " + id);
            return cart.get();
        }
    }

    //Ability to serve to controller's update quantity of books in cart api call
    public Cart updateQuantity(Integer id, Integer quantity) {
        Optional<Cart> cart = cartRepo.findById(id);

        if (cart.isEmpty()) {
            throw new BookStoreException("Cart Record doesn't exists");
        } else {
                cartRepo.save(cart.get());
                log.info("Quantity in cart record updated successfully");

                return cart.get();
            }
        }
    }
