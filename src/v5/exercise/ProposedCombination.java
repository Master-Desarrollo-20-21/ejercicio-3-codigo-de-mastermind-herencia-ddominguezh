package v5.exercise;

import v5.exercise.enums.Color;

public class ProposedCombination extends Combination{

	@Override
	public void generate() {
		do {
			String colors = Console.getInstance().readString("Propose a combination: ");
			char[] chars = colors.toCharArray();
			this.colors = new Color[chars.length];
			for(int i = 0 ; i < chars.length ; i++ ) {
				this.colors[i] = Color.valueOf(chars[i]);
			}
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
