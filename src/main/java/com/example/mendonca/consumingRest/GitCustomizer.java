package com.example.mendonca.consumingRest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.mendonca.entity.GitHub;


public class GitCustomizer {

	
	public void consumerAPI() {
		RestTemplate template = new RestTemplate();
		//GET https://github.com/login/oauth/authorize, responseType
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.github.com")
				.path("users")
				.queryParam("uniom3") //https://api.github.com/users/uniom3
				.build();
		ResponseEntity<GitHub> entity =template.getForEntity(uri.toString(),GitHub.class);
		
		System.out.println(entity.getBody().getName());
	}
	
}
