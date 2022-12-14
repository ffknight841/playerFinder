// /////////////////////////////////////////////////////////////////////////////
// PLEASE DO NOT RENAME OR REMOVE ANY OF THE CODE BELOW.
// YOU CAN ADD YOUR CODE TO THIS FILE TO EXTEND THE FEATURES TO USE THEM IN YOUR WORK.
// /////////////////////////////////////////////////////////////////////////////

package com.scopic.javachallenge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scopic.javachallenge.dto.PlayerDTO;
import com.scopic.javachallenge.dto.PlayerSkillDTO;
import com.scopic.javachallenge.mappers.EntityMapper;
import com.scopic.javachallenge.models.Player;
import com.scopic.javachallenge.models.PlayerSkill;
import com.scopic.javachallenge.service.PlayerService;
import com.scopic.javachallenge.service.SkillService;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RestController
public class PlayerController {
	
	@Autowired
	@Lazy
	private EntityMapper entityMapper;
	
	private PlayerService playerService;
	private SkillService skillService;
	
	//Creates a new player with skills in the database 
    @PutMapping("/player")
    @ResponseBody
    public ResponseEntity<PlayerDTO> create(@RequestBody PlayerDTO playerDTO) {
    	Player playerReq = entityMapper.map(playerDTO, Player.class);
   		Player player = playerService.save(playerReq);
   		PlayerDTO playerRes = entityMapper.map(player, PlayerDTO.class);
    	return new ResponseEntity<PlayerDTO>(playerRes, HttpStatus.CREATED); 		          
    }
    
  //Adds a new skill for a player to the skills table, uses Player ID for {id} 
    @PostMapping("/player/skill/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> createSkill(@PathVariable final Long id,@RequestBody PlayerSkillDTO playerSkillDTO) {
    	playerSkillDTO.setPlayer(id);
    	PlayerSkill playerSkillReq = entityMapper.map(playerSkillDTO, PlayerSkill.class);
    	PlayerSkill playerskill = skillService.save(playerSkillReq);
    	PlayerDTO playerRes = entityMapper.map(playerRes, PlayerDTO.class);
    	return new ResponseEntity<PlayerDTO>(playerRes, HttpStatus.CREATED);   	
    }
	
	//List all players and their associated skills 
    @GetMapping("/player,{position}")
    @ResponseBody
    public ResponseEntity<List<PlayerDTO>> index(Optional<String> position) {
    	if (position.isPresent()) {
    		List<Player> players = playerService.findByPosition(position);
    		List<PlayerDTO> playersDTO = entityMapper.mapAsList(players, PlayerDTO.class);
    		return new ResponseEntity<List<PlayerDTO>>(playersDTO, HttpStatus.FOUND);
    	}
    	else {
    	List<Player> players = playerService.findAllPlayers();
    	List<PlayerDTO> playersDTO = entityMapper.mapAsList(players, PlayerDTO.class);
    	return new ResponseEntity<List<PlayerDTO>>(playersDTO, HttpStatus.FOUND);
    	}
    }
    
  //Find a specific player via their ID
    @GetMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> find(@PathVariable final Long id) {
    	Optional<Player> player = playerService.findPlayer(id);
    	PlayerDTO playerRes = entityMapper.map(player, PlayerDTO.class);  
    	return new ResponseEntity<PlayerDTO>(playerRes, HttpStatus.CREATED); 
    }
    
  //Updates player values in the player and skills tables
    @PutMapping("/player/{id}")
    @ResponseBody
    public ResponseEntity<PlayerDTO> update(@PathVariable final Long id,@RequestBody PlayerDTO playerDTO) {
    	playerDTO.setId();
    	Player playerReq = entityMapper.map(playerDTO, Player.class);
    	Player player = playerService.save(playerReq);
    	PlayerDTO playerRes = entityMapper.map(player, PlayerDTO.class);
        return new ResponseEntity<PlayerDTO>(playerRes, HttpStatus.OK); 
    }   

    //Remove a player and skills from the database
    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
    	playerService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
