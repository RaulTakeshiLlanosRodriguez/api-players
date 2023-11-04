package com.api.players.service;

import java.util.List;

import com.api.players.dto.PlayerDTO;
import com.api.players.model.Player;

public interface IPlayerService {
	
	List<PlayerDTO> getPlayers();
	Player save(PlayerDTO playerDTO);
	void delete(Player player);
	boolean existsId(Long id);
	Player findById(Long id);
}
