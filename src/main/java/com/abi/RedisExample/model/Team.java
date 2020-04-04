package com.abi.RedisExample.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Team {

	String name;
	String price;
	String ranking;
	List<Player> players;
	
}
