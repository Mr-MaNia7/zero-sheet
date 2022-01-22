package com.webproject.zerosheet.registration;

import com.webproject.zerosheet.user.User;
import com.webproject.zerosheet.user.UserRole;
import com.webproject.zerosheet.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final ValidateEmail validateEmail;

    public String register(RegistrationRequest request){
        boolean emailIsValid = validateEmail.test(request.getEmail());

        // If the email is not valid throw error
        if (!emailIsValid){
            throw new IllegalStateException("Invalid Email. Use a proper email!");
        }

        // Registering user if email is valid
        return userService.registerUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.REGULAR
                )
        );
    }
}
