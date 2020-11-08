package v7.exercise.menu;

import v5.exercise.Console;

public class FinishOption extends Option{

	@Override
	public void print() {
		Console.getInstance().write("(F)inish.");
	}
	
	@Override
	public boolean equals(String value) {
		return "F".equals(value);
	}

	@Override
	public void execute() {
		Console.getInstance().write("Bye bye.");
		System.exit(0);
	}
	
}
