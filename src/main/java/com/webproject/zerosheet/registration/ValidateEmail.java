package com.webproject.zerosheet.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class ValidateEmail implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // Returns true for test and demo case.
        // Regex will be implemented.
        return true;
    }
}
