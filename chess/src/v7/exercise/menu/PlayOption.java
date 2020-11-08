package v7.exercise.menu;

import v7.exercise.Chess;
import v7.exercise.Console;

public class PlayOption extends Option{

	private Chess chess;
	public PlayOption(Chess chess) {
		this.chess = chess;
	}
	
	@Override
	public void print() {
		Console.getInstance().write("(P)lay.");
	}

	@Override
	public boolean equals(String value) {
		return "P".equals(value);
	}

	@Override
	public void execute() {
		Console.getInstance().write("Play.");
		this.chess.play();
	}
	
}
