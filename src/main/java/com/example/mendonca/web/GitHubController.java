package com.example.mendonca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mendonca.web.dto.GitDto;

@RestController
public class GitHubController {
    @Autowired
    RestTemplate restTemplate;
  

    @GetMapping("/git")
    public ResponseEntity<GitDto[]> getGithubUsers() {
 	   ResponseEntity<GitDto[]> response =
 			   restTemplate.getForEntity(
 			   "https://api.github.com/users?since>500" ,
 			  GitDto[].class);
 	   System.out.println(GitDto[].class.toString());
 	  GitDto[] gitHubUsers = response.getBody();
 	   return new ResponseEntity<GitDto[]>(gitHubUsers, HttpStatus.CREATED);
    }	
  
   
}
