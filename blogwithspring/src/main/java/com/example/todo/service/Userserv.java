package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

 import com.example.todo.model.UserRegister;
import com.example.todo.repository.UserRegisterRepo;

@Service
public class Userserv implements UserDetailsService {

	@Autowired
	private  UserRegisterRepo userRegisterRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserRegister  saveUser(UserRegister register) {
		register.setPassword(encoder.encode(register.getPassword()));	

		return  userRegisterRepo.save(register);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserRegister> optionalAccount=userRegisterRepo.findOneByEmailIgnoreCase(email);
		if(!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Account not found");
		}
		UserRegister account=optionalAccount.get();
		
		List<GrantedAuthority> grantedauthority=new ArrayList<>();
		grantedauthority.add(new SimpleGrantedAuthority("some shit"));
		
		 
		return new User(account.getEmail(),account.getPassword(),grantedauthority);
	}

	public Optional<UserRegister> findbyemail(String email){
		return userRegisterRepo.findOneByEmailIgnoreCase(email);
	}
	
	public Optional<UserRegister> findbyid(int id){
		return userRegisterRepo.findById(id);
	}
}
