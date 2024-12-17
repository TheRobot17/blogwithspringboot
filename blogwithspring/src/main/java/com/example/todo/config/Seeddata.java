package com.example.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.todo.model.Blogattr;
import com.example.todo.model.UserRegister;
import com.example.todo.service.Blogserv;
import com.example.todo.service.Userserv;

@Component
public class Seeddata  implements CommandLineRunner
{

	
	
	@Autowired
	private Userserv userserv;
	
	@Autowired
	private Blogserv blogserv;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserRegister userRegister1=new UserRegister();
		userRegister1.setEmail("admin@gmail.com");
		userRegister1.setPassword("admin@123");
		userRegister1.setName("admin");
		userRegister1.setPhoneno("0987654321");
		userRegister1.setDob("10-1-1999");
		userRegister1.setAddress("bengaluru");
		
		userserv.saveUser(userRegister1);
		
		
		
		Blogattr b1=new Blogattr();
		b1.setTitle("Naruto");
		b1.setContent("The best anime so far .");
		
		blogserv.saveblog(b1);
		
	}

}
