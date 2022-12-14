package com.scopic.javachallenge.dto;

import com.scopic.javachallenge.enums.Skill;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class PlayerSkillDTO {
	
	private Long id;    

    private Skill skill;

    private Integer value;     
    
	private Long player;         

}
