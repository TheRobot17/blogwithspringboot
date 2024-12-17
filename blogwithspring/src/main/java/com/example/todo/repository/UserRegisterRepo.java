package com.example.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 import com.example.todo.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Integer> {

	
	
	Optional<UserRegister> findOneByEmailIgnoreCase(String email);
}
