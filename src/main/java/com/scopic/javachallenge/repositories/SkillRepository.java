// /////////////////////////////////////////////////////////////////////////////
// PLEASE DO NOT RENAME OR REMOVE ANY OF THE CODE BELOW.
// YOU CAN ADD YOUR CODE TO THIS FILE TO EXTEND THE FEATURES TO USE THEM IN YOUR WORK.
// /////////////////////////////////////////////////////////////////////////////

package com.scopic.javachallenge.repositories;

import com.scopic.javachallenge.models.Player;
import com.scopic.javachallenge.models.PlayerSkill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Player, Long> {

	PlayerSkill save(PlayerSkill playerSkillReq);

}
