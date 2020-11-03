package com.ddominguezh.master.v5.exercise;

import com.ddominguezh.master.v5.exercise.enums.Color;

public abstract class Combination {

	private static int COLORS_LENGTH = 4;
	protected Color[] colors;
	private Console console = new Console();
	
	public Combination() {
		this.colors = new Color[COLORS_LENGTH];
	}
	
	public abstract void generate();
	public abstract String toString();
	
	public boolean isValid() {
		if(!isValidLength()) {
			return false;
		}
		if(!isValidColors()) {
			return false;
		}
		if(haveRepeatingColors()) {
			return false;
		}
		return true;
	}
	private boolean isValidLength() {
		if(this.colors.length != COLORS_LENGTH) {
			console.write("Wrong proposed combination length");
			return false;
		}
		return true;
	}
	private boolean isValidColors() {
		for(Color color : this.colors) {
			if(color == null) {
				console.write("Wrong colors they must be: " + Color.shortNames());
				return false;
			}
		}
		return true;
	}
    private boolean haveRepeatingColors() {
    		for(int i = 0 ; i < this.colors.length ; i++) {
    			Color color = this.colors[i];
    			for( int j = i+1; j < this.colors.length ; j++) {
    				Color nextColor = this.colors[j];
    				if(color.equals(nextColor)) {
    					console.write("Wrong proposed, can not repeat color.");
    					return true;
    				}
    			}
    		}
    		return false;
    }
    
}
