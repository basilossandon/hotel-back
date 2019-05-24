package com.teamgeso.hotelback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.teamgeso.hotelback.Repositories")
public class HotelbackApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelbackApplication.class, args);
	}

}
