package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Blogattr;

@Repository
public interface Blogrepos extends JpaRepository<Blogattr, Integer> {

}
