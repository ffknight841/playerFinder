package com.scopic.javachallenge.service.imp;

import com.scopic.javachallenge.models.PlayerSkill;
import com.scopic.javachallenge.repositories.SkillRepository;
import com.scopic.javachallenge.service.SkillService;

public class SkillServiceImp implements SkillService{
	
	private SkillRepository skillRepository;

	@Override
	public PlayerSkill save(PlayerSkill playerSkillReq) {
		return skillRepository.save(playerSkillReq);		
	}
	
}
