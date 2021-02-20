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

import com.example.au.couchbasedemo.model.Footballmatchs;
import com.example.au.couchbasedemo.repository.FootballmatchRepository;

@RestController
public class FootballmatchController {
    
    @Autowired
    FootballmatchRepository footballmatchRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/footballmatchs")
    public Footballmatchs addFootballmatchPost(@RequestBody Footballmatchs newFootballmatch) {
        return footballmatchRepository.save(newFootballmatch);
    }
    
    @GetMapping("/footballmatchs/{id}")
    public Optional<Footballmatchs> getFootballmatch(@PathVariable String id) {
        if (footballmatchRepository.existsById(id)) {
            return footballmatchRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/footballmatchs/teamA/{teamA}")
    public Footballmatchs getFootballmatchByTeamA(@PathVariable String teamA) {
        return footballmatchRepository.findByTeamA(teamA);
    }
    
    @DeleteMapping("/footballmatchs/title/{title}/teamA/{teamA}")
    public List<Footballmatchs> deleteByTeamAAndTitle(@PathVariable String title, @PathVariable String teamA) {
        return footballmatchRepository.deleteBytitleAndteamA(title, teamA);
    }
    
    @DeleteMapping("/footballmatchs/{id}")
    public void deleteById(@PathVariable String id) {
        footballmatchRepository.deleteById(id);
    }

    @GetMapping("/footballmatchs/tags/{tags}")
    public List<Footballmatchs> getFootballmatchByTagName(@PathVariable List<String> tags) {
        List<Footballmatchs> footballmatchsList=new ArrayList<>();
       footballmatchRepository.findAll().forEach(Footballmatchs->{
           List<String> tagsInFootballmatch=Footballmatchs.getTags();
           for(String s:tags)
           {
               if(tagsInFootballmatch.contains(s))
               {
                   footballmatchsList.add(Footballmatchs);
                   break;
               }
           }
       });


            return footballmatchsList;
    }

}