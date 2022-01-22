package com.webproject.zerosheet.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request){
        return "worked";
    }
}
