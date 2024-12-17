package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String dob;
	private String phoneno;
	private String address;
	private String password;
	
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegister(String name, String email, String dob, String phoneno, String address) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneno = phoneno;
		this.address = address;
	}
	public UserRegister(int id, String name, String email, String dob, String phoneno, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneno = phoneno;
		this.address = address;
	}
	
	
	public UserRegister(int id, String name, String email, String dob, String phoneno, String address,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneno = phoneno;
		this.address = address;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRegister [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phoneno="
				+ phoneno + ", address=" + address + ", password=" + password + "]";
	}
	 		 
	
	 
	
	
	
}
