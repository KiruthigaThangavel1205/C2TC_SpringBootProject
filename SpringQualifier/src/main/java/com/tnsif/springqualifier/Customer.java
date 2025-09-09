package com.tnsif.springqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	private int cid;
	private String name;
	
@Autowired
@Qualifier ("food")
private ShoppingMall s1;

public  void order()
{
	s1.purchase();
}
}
