package com.bridgelabz.springbootrabbitmqbookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Login {
    private String loginID;
    private String email;
    private String password;

}
