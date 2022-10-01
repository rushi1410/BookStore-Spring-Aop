package com.bridgelabz.springbootrabbitmqbookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Changepassword {
    private String ChangepasswordID;
    private String email;
    private String newPassword;

}
