package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Movies;

public interface MovieRepository extends CrudRepository<Movies, String> {
	
	Movies findByHero(String hero);

	List deleteBytitleAndHero(String title, String hero);

}