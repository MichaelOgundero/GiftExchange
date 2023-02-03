package org.example.giftExchange;

import org.example.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class GiftExchange {

	private int tableGifts;
	private  ArrayList<Player> players = new ArrayList<>();
	public GiftExchange(){
		for(int i=0;i<23;i++){
			players.add(new Player(i+1));
		}
		this.tableGifts = 23;
	}

	public void getPlayers(){
		for (int i=0;i<players.size();i++) {
			System.out.println("Player: "+players.get(i).getName() +" " +"Gift: "+players.get(i).getGift());
		}
	}

	public void startGame(){
		while(checkIfPlayersHaveGifts()){
			for(int i=0;i<this.players.size();i++){
				int cup = this.selectCup();
				this.performAction(cup, players.get(i));
			}
		}

		System.out.println("Game Over");
		this.getPlayers();
	}

	public boolean checkIfPlayersHaveGifts(){
		return this.players.stream().anyMatch(player -> player.getGift()==null);
	}

	public void performAction(int action, Player player){
		if(action  == 1){
			this.TakeOne(player);
		}
		if(action  == 2){
			this.Trade(player);
		}
		if(action  == 3){
			this.ShiftLeft();
		}
		if(action  == 4){
			this.ShiftRight();
		}
		if(action  == 5){
			this.Steal(player);
		}
	}

	public int selectCup(){
		System.out.println((int) ((Math.random() * (5-1)) + 1));
		return (int) ((Math.random() * (5-1)) + 1);
	}

	public int selectGiftFromTable(){
		System.out.println((int) ((Math.random() * (23-1)) + 1));
		return (int) ((Math.random() * (23-1)) + 1);
	}
	public void TakeOne(Player player){
		if(player.getGift() == null){
			player.setGift(this.selectGiftFromTable());
			this.tableGifts--;
		}
	}

	public void Trade(Player player){
		if(player.getGift() == null){
			TakeOne(player);
			Player tradePartner = this.players.stream().filter(p->p.getGift()!=null).findAny().get();
			int temp = player.getGift();
			player.setGift(tradePartner.getGift());
			tradePartner.setGift(temp);
		}else{
			Player tradePartner = this.players.stream().filter(p->p.getGift()!=null).findAny().get();
			int temp = player.getGift();
			player.setGift(tradePartner.getGift());
			tradePartner.setGift(temp);
		}
	}

	public void ShiftLeft(){
		for(int i=0;i<23;i++){
			if(i==0){
				int temp = this.players.get(i).getGift();
				this.players.get(this.players.size()-1).setGift(temp);
			}
			int temp = this.players.get(i).getGift();
			this.players.get(i-1).setGift(temp);
		}
	}

	public void ShiftRight(){
		for(int i=0;i<23;i++){
			if(i==this.players.size()-1){
				int temp = this.players.get(i).getGift();
				this.players.get(0).setGift(temp);
			}
			int temp = this.players.get(i).getGift();
			this.players.get(i+1).setGift(temp);
		}
	}

	public void Steal(Player player){
		if(player.getGift()==null){
			Player stealPartner = this.players.stream().filter(p->p.getGift()!=null).findAny().get();
			player.setGift(stealPartner.getGift());
			stealPartner.setGift(null);
		}
	}
}
