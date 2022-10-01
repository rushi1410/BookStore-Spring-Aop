package com.bridgelabz.springbootrabbitmqbookstore.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChangepasswordStatus {
    private Changepassword changepassword ;
    private String status;//progress,completed
    private String message;
}
