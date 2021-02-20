
package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Footballmatchs {
    
    @Id
    String id;
    
    @NotNull
    @Field
    String title;
    
    @NotNull
    @Field
    String teamA;
    String teamB;
    
    
    
    @Field
    List<String> tags;
    
    @Field
    Date date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String topic) {
		this.title = title;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	
	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
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

	public Footballmatchs(String id, String title, String teamA, String teamB, List<String> tags, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.teamA = teamA;
		this.teamB = teamB;
		this.tags = tags;
		this.date = date;
	}
    
    
    
}
