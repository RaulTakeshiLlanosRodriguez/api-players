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

@RestController
@CrossOrigin
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
	public Player createPlayer(@RequestBody PlayerDTO player) {
		return playerService.save(player);
	}
	
	@PutMapping("player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Player updatePlayer(@RequestBody PlayerDTO playerDTO, @PathVariable Long id) {
		
		if(playerService.existsId(id)) {
			playerDTO.setId(id);
			return playerService.save(playerDTO);
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
	public Player showById(@PathVariable Long id) {
		return playerService.findById(id);
	}
	
}
