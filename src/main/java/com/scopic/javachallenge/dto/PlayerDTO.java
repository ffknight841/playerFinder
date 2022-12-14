package com.scopic.javachallenge.dto;

import java.util.List;

import com.scopic.javachallenge.enums.PlayerPosition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class PlayerDTO {
	
    private Long id;

    private String name;

    private PlayerPosition position;    

    private List<PlayerSkillDTO> playerSkills;
    
}
