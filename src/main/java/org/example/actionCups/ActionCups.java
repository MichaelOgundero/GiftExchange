package org.example.actionCups;

public enum ActionCups {
	TAKE_ONE(1),
	TRADE(2),
	SHIFT_LEFT(3),
	SHIFT_RIGHT(4),
	STEAL(5);

	private  int value;
	private ActionCups(int value){
		this.value = value;
	}



	ActionCups getValue(int value){
		for(ActionCups ac: ActionCups.values()){
			if(ac.value == value){
				return ac;
			}
		}
		return null;
	}
}
