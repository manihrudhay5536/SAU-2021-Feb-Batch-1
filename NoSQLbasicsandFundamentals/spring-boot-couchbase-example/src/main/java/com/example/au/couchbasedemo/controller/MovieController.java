package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Movies;
import com.example.au.couchbasedemo.repository.MovieRepository;


@RestController
public class MovieController {
    
    @Autowired
    MovieRepository movieRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/movies")
    public Movies addMoviePost(@RequestBody Movies newMovie) {
        return movieRepository.save(newMovie);
    }
    
    @GetMapping("/movies/{id}")
    public Optional<Movies> getMovie(@PathVariable String id) {
        if (movieRepository.existsById(id)) {
            return movieRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/movie/hero/{hero}")
    public Movies getMovieByHeroName(@PathVariable String hero) {
        return movieRepository.findByHero(hero);
    }
    
    @DeleteMapping("/movies/title/{titlec}/hero/{hero}")
    public List<Movies> deleteByHeroAndTitle(@PathVariable String title, @PathVariable String hero) {
        return movieRepository.deleteBytitleAndHero(title, hero);
    }
    
    @DeleteMapping("/movies/{id}")
    public void deleteById(@PathVariable String id) {
        movieRepository.deleteById(id);
    }

    @GetMapping("/movies/tags/{tags}")
    public List<Movies> getMovieByTagName(@PathVariable List<String> tags) {
        List<Movies> moviesList=new ArrayList<>();
       movieRepository.findAll().forEach(Movies->{
           List<String> tagsInMovie=Movies.getTags();
           for(String s:tags)
           {
               if(tagsInMovie.contains(s))
               {
                   moviesList.add(Movies);
                   break;
               }
           }
       });


            return moviesList;
    }

}