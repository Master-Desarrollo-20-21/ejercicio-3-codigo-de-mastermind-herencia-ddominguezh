package v7.exercise;

import v7.exercise.enums.DataPiece;
import v7.exercise.enums.Position;
import v7.exercise.pieces.Piece;

public class Coordinate {

	private int x;
	private int y;
	private Piece piece;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public char print() {
		if(this.piece != null) {
			return this.piece.name();
		}
		return ' ';
	}
	
	public void add(Piece piece) {
		this.piece = piece;
	}
	
	public boolean containsPieceOfMine(Player player) {
		return notEmpty() && this.piece.isPlayer(player);
	}
	
	public boolean containsPieceOfOpponent(Player player) {
		return notEmpty() && !this.piece.isPlayer(player);
	}
	
	public boolean containsKingOfOpponent(Player player) {
		return containsPieceOfOpponent(player) && this.piece.equals(DataPiece.KING);
	}
	
	public boolean empty() {
		return this.piece == null;
	}
	
	public boolean notEmpty() {
		return !empty();
	}
	
	public boolean canMove(Coordinate coordinate) {
		return this.piece.canMove(this, coordinate);
	}
	
	public void move(Coordinate coordinate) {
		this.piece.move();
		coordinate.piece = this.piece;
		this.piece = null;
	}
	
	public int compareX(Coordinate coordinate) {
		return this.x - coordinate.x;
	}
	
	public int compareY(Coordinate coordinate) {
		return this.y - coordinate.y;
	}
	
	public int distance(Coordinate coordinate) {
		Position position = getPosition(coordinate);
		if(position == null) {
			return -1;
		}
		if(position.isVertical()) {
			return Math.abs(this.x - coordinate.x) ;
		}
		return Math.abs(this.y - coordinate.y) ;
	}
	
	public Position getPosition(Coordinate coordinate) {
		return Position.valueOf(this.compareX(coordinate), this.compareY(coordinate));
	}
	
	public Coordinate getMinimum(Coordinate coordinate) {
		Position position = getPosition(coordinate);
		if(position.isMinor()) {
			return this;
		}
		return coordinate;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

}
