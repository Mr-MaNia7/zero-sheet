package com.webproject.zerosheet.user;

import com.webproject.zerosheet.user.role.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserFormData {

    private PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    };

    @NotNull
    @Size(min = 3, message = "Enter greater than 2 characters: ")
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @NotBlank(message = "Provide a username")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Use characters and numbers only")
    private String username;

    @NotNull
    @NotBlank(message = "Enter a password")
    private String password;

//    private boolean regularRole = false;


    public User convertData(){
        return new User(
                this.getFirstName(),
                this.getLastName(),
                this.getUsername(),
                encoder().encode(this.getPassword()),
                Role.REGULAR
        );
    }
}
