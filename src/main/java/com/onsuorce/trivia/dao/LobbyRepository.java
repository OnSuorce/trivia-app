package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Lobby;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LobbyRepository extends MongoRepository<Lobby, String> {
}

