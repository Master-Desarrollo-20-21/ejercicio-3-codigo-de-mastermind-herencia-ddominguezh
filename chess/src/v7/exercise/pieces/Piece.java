package v7.exercise.pieces;

import v7.exercise.Coordinate;
import v7.exercise.Player;
import v7.exercise.enums.DataPiece;

public abstract class Piece {

	protected Player player;
	protected boolean initialPosition;
	private DataPiece data;
	
	public Piece(Player player, DataPiece data) {
		this.player = player;
		this.data = data;
		this.initialPosition = true;
	}
	
	public char name() {
		return data.getName(this.player.isWhite());
	}
	
	public boolean isPlayer(Player player) {
		return this.player.equals(player);
	}
	
	public void move() {
		this.initialPosition = false;
	}

	public boolean equals(DataPiece piece) {
		return this.data.equals(piece);
	}
	
	public abstract boolean canMove(Coordinate origin, Coordinate destination);

}
