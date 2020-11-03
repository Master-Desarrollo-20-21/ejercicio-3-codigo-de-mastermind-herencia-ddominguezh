package com.ddominguezh.master.v5.exercise;

import com.ddominguezh.master.v5.exercise.enums.Color;

public class ProposedCombination extends Combination{

	@Override
	public void generate() {
		Console console = new Console();
		do {
			this.colors = Color.values(console.readString("Propose a combination: "));
		}while(!isValid());
	}

	@Override
	public String toString() {
		String result = "";
		for(Color color : this.colors) {
			result += ""+color.shortName();
		}
		return result;
	}

}
