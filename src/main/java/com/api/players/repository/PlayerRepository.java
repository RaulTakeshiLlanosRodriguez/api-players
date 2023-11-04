package com.api.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.players.dto.PlayerDTO;
import com.api.players.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	List<PlayerDTO> findPlayerBy();
}
