package com.tnsif.springqualifier;

import org.springframework.stereotype.Component;

@Component
public class Food implements ShoppingMall {
	public void purchase()
	{
		System.out.println("Iam going to Order Food...");
	}

}
