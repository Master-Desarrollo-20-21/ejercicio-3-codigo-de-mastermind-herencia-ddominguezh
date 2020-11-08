package v7.exercise.menu;

import v7.exercise.Console;
import v7.exercise.Turn;

public class GiveUpOption extends Option{

	private Turn turn;
	public GiveUpOption(Turn turn) {
		this.turn = turn;
	}
	
	@Override
	public void print() {
		Console.getInstance().write("(G)iveUp.");
	}
	
	@Override
	public boolean equals(String value) {
		return "G".equals(value);
	}
	
	@Override
	public void execute() {
		this.turn.giveUp();
	}
	
}
