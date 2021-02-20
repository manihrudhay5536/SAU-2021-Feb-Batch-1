package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Footballmatchs;

public interface FootballmatchRepository extends CrudRepository<Footballmatchs, String> {
	
	Footballmatchs findByTeamA(String teamA);

	List deleteBytitleAndteamA(String title, String teamA);

}
