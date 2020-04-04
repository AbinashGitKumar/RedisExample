package com.abi.RedisExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abi.RedisExample.model.Player;
import com.abi.RedisExample.service.PlayerService;

@RestController
public class IplBettingController {
	
	@Autowired
	PlayerService playerService;

	@GetMapping(value="/teams")
	public ResponseEntity<?> getAllTeams()
	
	{
		return null;
	}
	
	@GetMapping(value="/players")
	public ResponseEntity<?> getAllPlayers()
	{
		List<Player> allPlayersList=	 playerService.getAllPlayers();
		return new ResponseEntity(allPlayersList, HttpStatus.OK);
	}
	
	@PostMapping(value="/players")
	public ResponseEntity<?> insertPlayer(@RequestBody Player player)
	{
		return playerService.addPlayer(player);
	}
	
	@PutMapping(value="/players")
	public ResponseEntity<?> updatePlayer(@RequestBody Player player) {
		return new ResponseEntity(playerService.updatePlayer(player), HttpStatus.OK);
	}
	
	@GetMapping("/player/{name}")
	public ResponseEntity<?> getPlayerByName(@PathVariable(value = "name") String name) {
		return new ResponseEntity(playerService.getPlayerByName(name), HttpStatus.OK);
	}
	

}
