package v5.exercise;

import v5.exercise.enums.Color;

public abstract class Combination {

	private static int COLORS_LENGTH = 4;
	protected Color[] colors; 
	
	public Combination() {
		this.colors = new Color[COLORS_LENGTH];
	}
	
	public abstract void generate();
	public abstract String toString();
	
	public boolean isValid() {
		if(!isValidLength()) {
			Console.getInstance().write("Wrong proposed combination length");
			return false;
		}
		if(!isValidColors()) {
			Console.getInstance().write("Wrong colors they must be: " + Color.shortNames());
			return false;
		}
		if(haveRepeatingColors()) {
			Console.getInstance().write("Wrong proposed, can not repeat color.");
			return false;
		}
		return true;
	}
	private boolean isValidLength() {
		return this.colors.length == COLORS_LENGTH;
	}
	private boolean isValidColors() {
		for(Color color : this.colors) {
			if(color == null) {
				return false;
			}
		}
		return true;
	}
    private boolean haveRepeatingColors() {
    		for(int i = 0 ; i < this.colors.length ; i++) {
    			Color color = this.colors[i];
    			for( int j = i+1; j < this.colors.length ; j++) {
    				if(color.equals(this.colors[j])) {
    					return true;
    				}
    			}
    		}
    		return false;
    }
    
}
