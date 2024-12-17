package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Blogattr;
import com.example.todo.repository.Blogrepos;

@Service
public class Blogserv {

	@Autowired
	private Blogrepos blogrepos;

	
	public Blogattr saveblog(Blogattr blogattr) {
		return blogrepos.save(blogattr);
	}
	
	public List<Blogattr> listblog(){
		return blogrepos.findAll();	
	
	}
}
