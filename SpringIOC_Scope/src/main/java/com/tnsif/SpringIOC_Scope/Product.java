package com.tnsif.SpringIOC_Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = "prototype")
public class Product {
	private int id;
	private String name;
	public Product()
	{  
		System.out.println("Product class object created");
	}

}
