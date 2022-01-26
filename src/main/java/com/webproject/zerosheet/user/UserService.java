package com.webproject.zerosheet.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void newUser(User user){
        userRepo.save(user);
    }
}
