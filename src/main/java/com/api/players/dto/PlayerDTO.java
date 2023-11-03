package com.api.players.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerDTO {
	
	private Long id;
	private String namePlayer;
	private String age;
	private String team;
	private String position;
	private String urlImage;
}
