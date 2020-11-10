package v5.exercise;

import v5.exercise.enums.Spike;

public class Attempt {

	private ProposedCombination proposed;
	private Pig[] pigs;
	
	public Attempt() {
		this.proposed = new ProposedCombination();
	}
	
	public Attempt play() {
		this.proposed.generate();
		return this;
	}

	public Attempt result(SecretCombination secret) {
		this.pigs = secret.compare(this.proposed);
		return this;
	}
	
	public void print() {
		Console.getInstance().write(this.proposed.toString() + " ---> " + numPigs(Pig.BLACK)  + " blacks - " + numPigs(Pig.WHITE) + " whites.");
	}

	private int numPigs(Pig foundPig) {
		int count = 0;
		for(Pig pig : this.pigs) {
			if(foundPig.equals(pig)) {
				count++;
			}
		}
		return count;
	}

	public boolean isWinner() {
		return numPigs(Pig.BLACK) == this.pigs.length;
	}

}
