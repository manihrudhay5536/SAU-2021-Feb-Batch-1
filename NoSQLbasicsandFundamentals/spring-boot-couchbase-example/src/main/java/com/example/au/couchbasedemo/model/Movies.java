package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Movies {
    
    @Id
    String id;
    
    @NotNull
    @Field
    String title;
    
    @NotNull
    @Field
    String hero;
    
    @Field
    List<String> tags;
    
    @Field
    Date date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public Movies(String id, String title, String hero, List<String> tags, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.hero = hero;
		this.tags = tags;
		this.date = date;
	}
    
    
    
}
