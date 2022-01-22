package com.webproject.zerosheet.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String errorMessage = "User with username -  %s - not found!!!";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(errorMessage
        , email)));
    }

    public String registerUser(User user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        // User already in database
        if(userExists){
            throw new IllegalStateException("Email already taken! Use another email");
        }

        // Encode user password
       String userEncoded = bCryptPasswordEncoder.encode(user.getPassword());

        // Setting the user password to the encoded one
        user.setPassword(userEncoded);

        // Saving user
        userRepository.save(user);

        // Working message
        return "Registered";
    }
}
