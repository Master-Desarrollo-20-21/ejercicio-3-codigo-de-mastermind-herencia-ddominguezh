package com.ddominguezh.master.v5.exercise;

import com.ddominguezh.master.v5.exercise.enums.Spike;

public class Attempt {

	private ProposedCombination proposed;
	private Spike[] spikes;
	private Console console = new Console();
	public Attempt() {
		this.proposed = new ProposedCombination();
	}
	public Attempt play() {
		this.proposed.generate();
		return this;
	}

	public Attempt result(SecretCombination secret) {
		this.spikes = secret.compare(this.proposed);
		return this;
	}
	
	public void print() {
		console.write(this.proposed.toString() + " ---> " + numSpikes(Spike.BLACK)  + " blacks - " + numSpikes(Spike.WHITE) + " whites.");
	}

	private int numSpikes(Spike foundSpike) {
		int count = 0;
		for(Spike spike : this.spikes) {
			if(foundSpike.equals(spike)) {
				count++;
			}
		}
		return count;
	}

	public boolean isWinner() {
		return numSpikes(Spike.BLACK) == 4;
	}

}
