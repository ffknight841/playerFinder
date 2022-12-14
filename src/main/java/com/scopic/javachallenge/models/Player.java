// /////////////////////////////////////////////////////////////////////////////
// PLEASE DO NOT RENAME OR REMOVE ANY OF THE CODE BELOW.
// YOU CAN ADD YOUR CODE TO THIS FILE TO EXTEND THE FEATURES TO USE THEM IN YOUR WORK.
// /////////////////////////////////////////////////////////////////////////////

package com.scopic.javachallenge.models;

import com.scopic.javachallenge.enums.PlayerPosition;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private PlayerPosition position;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "player", referencedColumnName = "id")
    private List<PlayerSkill> playerSkills;    
    
}
