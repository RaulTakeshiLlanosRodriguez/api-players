package com.api.players.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlayerDTO {
	
	private Long id;
	private String namePlayer;
	private String age;
	private String team;
	private String position;
	private String urlImage;
}
