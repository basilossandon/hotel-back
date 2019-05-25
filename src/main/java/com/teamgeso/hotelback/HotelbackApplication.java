package com.teamgeso.hotelback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@ComponentScan("com.teamgeso.hotelback.services")
public class HotelbackApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelbackApplication.class, args);
	}

}
