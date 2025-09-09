package com.tnsif.springqualifier;

import org.springframework.stereotype.Component;

@Component
public class Electronics implements ShoppingMall {
	public void purchase()
	{
		System.out.println("Iam going to purchase gadgets...");
	}
}
