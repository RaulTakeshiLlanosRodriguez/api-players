package com.api.players.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.players.dto.PlayerDTO;
import com.api.players.model.Player;
import com.api.players.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService{
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<PlayerDTO> getPlayers() {
		return playerRepository.findPlayerBy();
	}

	@Override
	public Player save(PlayerDTO playerDTO) {
		Player playerSave = Player.builder().id(playerDTO.getId())
				.namePlayer(playerDTO.getNamePlayer())
				.age(playerDTO.getAge())
				.team(playerDTO.getTeam())
				.position(playerDTO.getPosition())
				.urlImage(playerDTO.getUrlImage())
				.logoTeam(playerDTO.getLogoTeam())
				.build();
		return playerRepository.save(playerSave);
	}

	@Override
	public void delete(Player player) {
		playerRepository.delete(player);
	}

	@Override
	public boolean existsId(Long id) {
		return playerRepository.existsById(id);
	}

	@Override
	public Player findById(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		return player;
	}

}
