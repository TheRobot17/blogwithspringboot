package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Blogattr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	 
	private String title;
	
	 
	private String content;
	
	public Blogattr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blogattr(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Blogattr(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blogattr [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
