package com.labyrinth.fantasyfootball.model;

import java.util.List;

public class Franchise {
	private List<Player> player;
	private String id;
	
	public List<Player> getPlayer() {
		return player;
	}
	public void setPlayer(List<Player> player) {
		this.player = player;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
