package com.tnsif.restfulapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo 
{
	@RequestMapping("/HelloWorld")
	public String show()
	{
		return "Welcome";
	}
	
	@GetMapping("/Hello")
	public String greetings(@RequestParam String name)
	{
		return "Welcome "+name;
	}
	
	@GetMapping("/Hello/{name}")
	public String message (@PathVariable String name)
	{
		return "Welcome"+name;
	}
}

