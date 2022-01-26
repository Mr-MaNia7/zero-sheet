package com.webproject.zerosheet.customer;

import com.webproject.zerosheet.user.User;
import com.webproject.zerosheet.user.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotNull
    @Size(min = 3, message = "Enter greater than 2 characters: ")
    private String fullName;

    @NotNull
    @Size(min = 3, message = "Enter greater than 2 characters: ")
    private String commonNameAddress;

    @NotNull
    @Size(min = 3, message = "Enter greater than 2 characters: ")
    private String cityAddress;

    @NotNull
    @Size(min = 3, message = "Enter greater than 2 characters: ")
    private String contactNo;

}
