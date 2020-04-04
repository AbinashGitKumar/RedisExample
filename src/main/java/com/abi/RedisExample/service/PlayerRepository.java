package com.abi.RedisExample.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abi.RedisExample.model.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

	Player findByName(String name);

}
