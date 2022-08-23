package com.mayyar.springone.SpringOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class SpringOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}
////	@RestController
//	@RequestMapping("/api")
//	public class ApiController{
//		@GetMapping("/greeting")
//		public String getGreeting(){
//			return "Hello World from api";
//		}
//	}
}
