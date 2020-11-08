package v7.exercise;

import v7.exercise.enums.Color;

public class Chess {

	private Board board;
	private Turn turn;
	private Player whites;
	private Player blacks;
	private Menu menu;
	
	public Chess() {
		this.menu = new MainMenu(this);
	}
	public void init() {
		this.menu.print();
	}
	
	public void play() {
		this.board = new Board();
		this.whites = new Player(Color.WHITE, this.board.getRow(0), this.board.getRow(1));
		this.blacks = new Player(Color.BLACK, this.board.getRow(7), this.board.getRow(6));
		this.turn = new Turn(this, this.whites, this.board);
		next();
	}

	public void next(Player player) {
		if(player.isWhite()) {
			this.turn.change(this.blacks);
		}else {
			this.turn.change(this.whites);
		}
		this.next();
	}
	
	public void next() {
		this.board.print();
		this.turn.start();
	}

	public void finish() {
		init();
	}
	
	public static void main(String[] args) {
		new Chess().init();
	}
	
}
