package v5.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import v5.exercise.enums.Color;
import v5.exercise.enums.Spike;

public class SecretCombination extends Combination{

	@Override
	public void generate() {
		List<Color> values = Arrays.asList(Color.values());
	    Collections.shuffle(values);
		for( int i = 0 ; i < this.colors.length ; i++) {
			this.colors[i] = values.get(i);
		}
		Console.getInstance().write("Secrect Combination: " + this.toString());
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0 ; i < this.colors.length ; i++ ) {
			result += "x";
		}
		return result;
	}

	public Spike[] compare(ProposedCombination combination) {
		Spike[] spikes = new Spike[this.colors.length];
		for(int i = 0 ; i < this.colors.length ; i++ ) {
			int index = indexOf(this.colors[i], combination);
			if(index == i) {
				spikes[i] = Spike.BLACK;
			}else if(index > -1) {
				spikes[i] = Spike.WHITE;
			}
		}
		return spikes;
	}

	public int indexOf(Color color, Combination combination) {
		for (int i = 0 ; i < combination.colors.length ; i++ ) {
			if(color.equals(combination.colors[i])) {
				return i;
			}
		}
		return -1;
	}
	
}
