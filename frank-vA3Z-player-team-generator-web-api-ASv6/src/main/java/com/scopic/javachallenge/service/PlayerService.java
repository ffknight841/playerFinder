package com.scopic.javachallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scopic.javachallenge.models.Player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Service
public interface PlayerService {
	
	List<Player> findAllPlayers();

	Player save(Player playerReq);

	Optional<Player> findPlayer(Long id);

	void delete(Long id);

	List<Player> findByPosition(Optional<String> position);

}
