package com.tnsif.springqualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringQualifierApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext var = SpringApplication.run(SpringQualifierApplication.class, args);
		Customer c1 = var.getBean(Customer.class);
		c1.order();
	}

}
