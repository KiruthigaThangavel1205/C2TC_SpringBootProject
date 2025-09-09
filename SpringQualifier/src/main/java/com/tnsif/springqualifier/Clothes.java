package com.tnsif.springqualifier;

import org.springframework.stereotype.Component;

@Component
public class Clothes implements ShoppingMall {
	public void purchase()
	{
		System.out.println("Iam going to purchase Dresses...");
	}
}
