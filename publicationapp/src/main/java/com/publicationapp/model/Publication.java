package com.publicationapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String content;

	public Publication() {
		super();
	}

	public Publication(int id, String title, String type, String content) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content + "]";
	}
	
	
	
	
	
}
