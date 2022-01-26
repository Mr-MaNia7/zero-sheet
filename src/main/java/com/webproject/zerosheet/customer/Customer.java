package com.webproject.zerosheet.customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custID;

    @NotNull
    @NotBlank(message = "Please enter customers name")
    @Size(min = 3, message = "Input must be greater than 3 characters")
    private String fullName;

    @NotNull
    @NotBlank(message = "Please enter customers address common name")
    @Size(min = 3, message = "Input must be greater than 3 characters")
    private String commonNameAddress;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "Input must be greater than 3 characters")
    private String cityAddress;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "Input must be greater than 3 characters")
    private String contactNo;

    public Customer(String custName, String commonNameAddress, String cityAddress, String contactNo) {
    }
}
