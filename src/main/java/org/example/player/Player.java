package org.example.player;

import java.util.ArrayList;

public class Player {
	private int name;
	private Integer gift;

	public Player(int name){
		this.name = name;
		this.gift =  null;
	}

	public int getName(){
		return this.name;
	}

	public Integer getGift(){
		return this.gift;
	}

	public void  setGift(Integer gift){
		this.gift = gift;
	}
}
