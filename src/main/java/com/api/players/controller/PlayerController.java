package com.api.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.players.dto.PlayerDTO;
import com.api.players.model.Player;
import com.api.players.service.IPlayerService;


@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;
	
	
	@GetMapping("players")
	public List<PlayerDTO> getPlayers(){
		return playerService.getPlayers();
	}
	
	@PostMapping("player")
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerDTO createPlayer(@RequestBody PlayerDTO player) {
		Player playerCreate = playerService.save(player);
		player = PlayerDTO.builder().id(playerCreate.getId())
				.namePlayer(playerCreate.getNamePlayer())
				.age(playerCreate.getAge())
				.team(playerCreate.getTeam())
				.position(player.getPosition())
				.urlImage(playerCreate.getUrlImage())
				.build();
		return player;
	}
	
	@PutMapping("player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO, @PathVariable Long id) {
		
		if(playerService.existsId(id)) {
			playerDTO.setId(id);
			Player playerEditado = playerService.save(playerDTO);
			playerDTO = PlayerDTO.builder().id(playerEditado.getId())
					.namePlayer(playerEditado.getNamePlayer())
					.age(playerEditado.getAge())
					.team(playerEditado.getTeam())
					.position(playerEditado.getPosition())
					.urlImage(playerEditado.getUrlImage())
					.build();
			return playerDTO;
		}else {
			return null;
		}
	}
	
	@DeleteMapping("player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayer(@PathVariable Long id) {
		
		Player player = playerService.findById(id);
		playerService.delete(player);
	}
	
	@GetMapping("player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PlayerDTO showById(@PathVariable Long id) {
		Player playerEncontrado = playerService.findById(id);
		return PlayerDTO.builder().id(playerEncontrado.getId())
				.namePlayer(playerEncontrado.getNamePlayer())
				.age(playerEncontrado.getAge())
				.team(playerEncontrado.getTeam())
				.position(playerEncontrado.getPosition())
				.urlImage(playerEncontrado.getUrlImage())
				.build();
	}
	
}
