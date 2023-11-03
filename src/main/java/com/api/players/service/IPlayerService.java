package com.api.players.service;

import java.util.List;

import com.api.players.dto.PlayerDTO;

public interface IPlayerService {
	
	List<PlayerDTO> getPlayers();
}
