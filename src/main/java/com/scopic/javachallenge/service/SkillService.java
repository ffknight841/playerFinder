package com.scopic.javachallenge.service;

import org.springframework.stereotype.Service;

import com.scopic.javachallenge.models.PlayerSkill;

@Service
public interface SkillService {
	
	PlayerSkill save(PlayerSkill playerSkillReq);

}
