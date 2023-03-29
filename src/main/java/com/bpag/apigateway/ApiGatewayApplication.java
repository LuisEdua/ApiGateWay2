package com.bpag.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		/*BCryptPasswordEncoder ba = new BCryptPasswordEncoder();
		String admin = ba.encode("admin");
		System.out.println("-----------------");
		System.out.println(admin);*/
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}