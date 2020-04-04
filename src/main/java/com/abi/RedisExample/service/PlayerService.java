package com.abi.RedisExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abi.RedisExample.model.Player;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Cacheable(value="PLAYERS_LIST")
	public List<Player> getAllPlayers() {
		System.out.println("CACHE NOT WORKING");
		List<Player> allPlayersList = playerRepo.findAll();
		return allPlayersList;
	}
	

	public ResponseEntity<?> addPlayer(Player player) {
		Player savedPlayer = playerRepo.save(player);
		return new ResponseEntity(savedPlayer, HttpStatus.CREATED);
	}

	public Player updatePlayer(Player player) {
		Player findPlayer = playerRepo.findByName(player.getName());
		findPlayer.setMatches(player.getMatches());
		findPlayer.setRuns(player.getRuns());
		findPlayer.setWickets(player.getWickets());
		Player updatedPlayer = playerRepo.save(findPlayer);
		return updatedPlayer;
	}

	@Cacheable(value="#name")
	public Player getPlayerByName(String name)
	{
		System.out.println("GETTING PLAYER DETAILS, HITTING MONGO DB");
		Player player= playerRepo.findByName(name);
		 return player;
	}
	
}
