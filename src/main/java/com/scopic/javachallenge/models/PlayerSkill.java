// /////////////////////////////////////////////////////////////////////////////
// PLEASE DO NOT RENAME OR REMOVE ANY OF THE CODE BELOW.
// YOU CAN ADD YOUR CODE TO THIS FILE TO EXTEND THE FEATURES TO USE THEM IN YOUR WORK.
// /////////////////////////////////////////////////////////////////////////////

package com.scopic.javachallenge.models;

import com.scopic.javachallenge.enums.Skill;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "player_skills")
@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class PlayerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    

    private Skill skill;

    private Integer value; 
    
    private Long player;   
        
}