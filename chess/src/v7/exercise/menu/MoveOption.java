package v7.exercise.menu;

import v7.exercise.Board;
import v7.exercise.Console;
import v7.exercise.Movement;
import v7.exercise.Turn;

public class MoveOption extends Option{

	private Turn turn;
	private Board board;
	public MoveOption(Turn turn, Board board) {
		this.turn = turn;
		this.board = board;
	}
	
	@Override
	public void print() {
		Console.getInstance().write("(M)ove.");
	}
	
	@Override
	public boolean equals(String value) {
		return "M".equals(value);
	}
	
	@Override
	public void execute() {
		String answer;
		Movement movement = new Movement(this.turn, this.board);
		do {
			answer = Console.getInstance().readString("Move (D2 at D4): ");
		}while(!movement.load(answer).isValid());
		movement.execute();
	}
	
}
