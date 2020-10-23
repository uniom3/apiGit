package com.example.mendonca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mendonca.entity.GitHub;

@RestController
public class GitHubController {
    @Autowired
    RestTemplate restTemplate;
  

    @GetMapping("/git")
    public ResponseEntity<GitHub[]> getGithubUsers() {
 	   ResponseEntity<GitHub[]> response =
 			   restTemplate.getForEntity(
 			   "https://api.github.com/users?since>500" ,
 			   GitHub[].class);
 	   System.out.println(GitHub[].class.toString());
 	   GitHub[] gitHubUsers = response.getBody();
 	   return new ResponseEntity<GitHub[]>(gitHubUsers, HttpStatus.CREATED);
    }	
  
   
}
