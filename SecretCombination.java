package com.ddominguezh.master.v5.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ddominguezh.master.v5.exercise.enums.Color;
import com.ddominguezh.master.v5.exercise.enums.Spike;

public class SecretCombination extends Combination{

	@Override
	public void generate() {
		List<Color> values = Arrays.asList(Color.values());
	    Collections.shuffle(values);
		for( int i = 0 ; i < this.colors.length ; i++) {
			this.colors[i] = values.get(i);
		}
		Console console = new Console();
		console.write("Secrect Combination: " + this.toString());
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
			if(this.equals(i, combination.colors[i])) {
				spikes[i] = Spike.BLACK;
			}else if(this.contains(i, combination)) {
				spikes[i] = Spike.WHITE;
			}
		}
		return spikes;
	}

    public boolean contains(int index, Combination combination) {
    		for (int i = 0 ; i < combination.colors.length ; i++ ) {
			if(equals(index, combination.colors[i])) {
				return true;
			}
		}
		return false;
    }
    
    private boolean equals(int index, Color color) {
    		return this.colors[index].equals(color);
    }
}
