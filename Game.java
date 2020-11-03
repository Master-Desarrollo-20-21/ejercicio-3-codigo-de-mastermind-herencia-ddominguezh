package com.ddominguezh.master.v5.exercise;

import com.ddominguezh.master.v5.exercise.enums.Color;

public class Game {

	private final static int MAX_ATTEMTPS = 10;
	private SecretCombination secret;
	private Attempt[] attempts;
	private int numAttempts;
	private Console console = new Console();
	public Game() {
		this.secret = new SecretCombination();
		this.attempts = new Attempt[MAX_ATTEMTPS];
		for(int i = 0 ; i < MAX_ATTEMTPS ; i++ ) {
			this.attempts[i] = new Attempt();
		}
	}
	public void play() {
		reset();
		do {
			console.write("Attempt " + this.numAttempts +", Colors: " + Color.shortNames());
			attempts[this.numAttempts].play().result(this.secret);
			this.numAttempts++;
			printAttempts();
		}while(haveMoreAttempts());
		finish();
	}
	private void reset() {
		this.secret.generate();
		this.numAttempts = 0;
	}
	private void printAttempts() {
		for(int j = 0 ; j < this.numAttempts ; j++) {
			attempts[j].print();
		}
		console.write("");
	}
	private boolean haveMoreAttempts() {
		return !lastAttempt().isWinner() && this.numAttempts < MAX_ATTEMTPS;
	}
	private void finish() {
		if(lastAttempt().isWinner()) {
			console.write("You're winner :-)!!");
		}else {
			console.write("You loose :-(");
		}
	}
	private Attempt lastAttempt() {
		return this.attempts[this.numAttempts - 1];
	}
}
