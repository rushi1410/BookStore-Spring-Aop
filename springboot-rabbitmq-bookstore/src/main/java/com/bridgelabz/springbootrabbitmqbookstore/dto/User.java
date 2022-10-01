package com.bridgelabz.springbootrabbitmqbookstore.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userID;
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
