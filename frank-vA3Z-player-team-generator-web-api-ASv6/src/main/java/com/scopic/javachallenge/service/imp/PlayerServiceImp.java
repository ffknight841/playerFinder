package com.scopic.javachallenge.service.imp;

import java.util.List;
import java.util.Optional;

import com.scopic.javachallenge.models.Player;
import com.scopic.javachallenge.repositories.PlayerRepository;
import com.scopic.javachallenge.service.PlayerService;

public class PlayerServiceImp implements PlayerService{
	
	private PlayerRepository playerRepository;
	
	@Override
	public List<Player> findAllPlayers(){
		return playerRepository.findAll();
	}
	
	@Override
	public Player save(Player playerReq) {
		return playerRepository.save(playerReq);
	}

	@Override
	public Optional<Player> findPlayer(Long id) {
		return playerRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		playerRepository.deleteById(id);
		return; 
	}

	@Override
	public List<Player> findByPosition(Optional<String> position) {
		return playerRepository.findByPosition(position);
	}

}
