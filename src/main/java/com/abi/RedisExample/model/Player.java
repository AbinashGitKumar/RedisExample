package com.abi.RedisExample.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
	
	private static final long serialVersionUID = 3641108111749765164L;
	
	@Id
	private String playerId;
	private String name;
	private String country;
	private String franchise;
	private String specialization;
	private Boolean canBat;
	private Boolean canBall;
	private Boolean isMarqueePlayer;
	private Integer runs;
	private Integer wickets;
	private Integer matches;

}
