package com.webproject.zerosheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ZeroSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeroSheetApplication.class, args);
	}

}
