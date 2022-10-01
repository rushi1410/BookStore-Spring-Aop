package com.bridgelabz.springbootrabbitmqbookstore.publisher;

import com.bridgelabz.springbootrabbitmqbookstore.config.MessagingConfig;
import com.bridgelabz.springbootrabbitmqbookstore.dto.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserPublisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setUserID(UUID.randomUUID().toString());
        UserStatus userStatus = new UserStatus(user, "PROCESS", "User registered successfully" );
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, userStatus);
        return "Success !!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Login login) {
        login.setLoginID(UUID.randomUUID().toString());
        LoginStatus loginStatus = new LoginStatus(login, "PROCESS", "User login successfully" );
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, loginStatus);
        return "Success !!";
    }

   @PostMapping("/changepassword")
   public String userChangepassword(@RequestBody  Changepassword changepassword) {
       changepassword.setChangepasswordID(UUID.randomUUID().toString());
       ChangepasswordStatus changepasswordStatus = new ChangepasswordStatus(changepassword, "PROCESS", "User changed password  successfully" );
       template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY,changepasswordStatus);
        return "Success !!";
   }
}
