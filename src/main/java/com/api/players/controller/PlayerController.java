package com.api.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.players.dto.PlayerDTO;
import com.api.players.service.IPlayerService;

@RestController
@RequestMapping("api/v1")
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;
	
	@GetMapping("players")
	public List<PlayerDTO> getPlayers(){
		return playerService.getPlayers();
	}
}
