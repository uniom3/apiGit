package com.example.mendonca.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;


public class GitHub {

	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("login")
	@Setter	
	private String login;
	
	@JsonProperty("url")
	@Setter
	private String url;

	@JsonProperty("name")
	@Setter
	private String name;
	
}
