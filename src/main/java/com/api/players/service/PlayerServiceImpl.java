package com.api.players.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.players.dto.PlayerDTO;
import com.api.players.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService{
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<PlayerDTO> getPlayers() {
		return playerRepository.findPlayerBy();
	}

}
