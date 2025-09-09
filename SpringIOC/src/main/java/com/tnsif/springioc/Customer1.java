package com.tnsif.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer1 {
	private int id;
	private String cname;
	@Autowired
	Customer2 cust2;
	@Autowired
	Customer3 cust3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void show()
	{
		System.out.println("Customer 1 object printed");
		cust2.show();
		cust3.show();
		
	}

}
