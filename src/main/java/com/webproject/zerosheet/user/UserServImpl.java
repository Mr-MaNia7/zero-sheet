package com.webproject.zerosheet.user;

import com.webproject.zerosheet.user.roles.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServImpl implements UserService{

    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserServImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // Authentication happens here. Username is looked up the database for login purpose.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }


    // Authorization happens here.
    // Map different user roles to authorization levels
    private Collection <? extends GrantedAuthority > mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    // Registering user
    @Override
    public User registerUser(UserDataTransfer userData) {
        User user = new User();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setUsername(userData.getUsername());
        user.setPassword(encoder.encode(userData.getPassword()));
        user.setRoles(Arrays.asList(new Role("REGULAR")));

        return userRepo.save(user);
    }

}
