package com.payconiq.stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class StocksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksServiceApplication.class, args);
	}

}
