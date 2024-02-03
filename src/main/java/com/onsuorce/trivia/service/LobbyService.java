package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.LobbyRepository;
import com.onsuorce.trivia.entity.Lobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LobbyService {

    @Autowired
    private LobbyRepository lobbyRepository;

    public Lobby createLobby(String name, String hostUserId) {
        Lobby lobby = new Lobby();
        lobby.setName(name);
        lobby.setHostUserId(hostUserId);
        lobby.setGameStarted(false);
        return lobbyRepository.save(lobby);
    }

    public Lobby joinLobby(String lobbyId, User user) {
        Lobby lobby = lobbyRepository.findById(lobbyId).orElseThrow(() -> new RuntimeException("Lobby not found"));
        lobby.getUsers().add(user);
        return lobbyRepository.save(lobby);
    }

    // Other methods...
}
