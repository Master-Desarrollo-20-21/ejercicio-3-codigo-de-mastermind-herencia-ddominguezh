package v7.exercise;

import v7.exercise.enums.Position;

public class Movement {

	private Turn turn;
	private Board board;
	private String movement;
	private Coordinate origin;
	private Coordinate destination;
	private Position position;
	public Movement(Turn turn, Board board) {
		this.turn = turn;
		this.board = board;
	}
	
	public Movement load(String movement) {
		this.movement = movement;
		this.origin = null;
		this.destination = null;
		Coordinate[] coordinates = this.board.getCoordinates(movement);
		if(coordinates != null) {
			this.origin = coordinates[0];
			this.destination = coordinates[1];
			this.position = this.origin.getPosition(this.destination);
		}
		return this;
	}

	public boolean isValid() {
		return this.position != null 
				&& this.freeWay()
				&& this.origin.containsPieceOfMine(this.turn.getPlayer()) 
				&& !this.destination.containsPieceOfMine(this.turn.getPlayer())
				&& this.origin.canMove(this.destination);
	}

	public boolean freeWay() {
		int distance = this.origin.distance(this.destination);
		if(distance > 1 && !Position.L_SHAPE.equals(this.position)) {
			Coordinate minimum = origin.getMinimum(this.destination);
			int i = 0, j = 0, max = distance - 1;
			do {
				
				if(position.isVertical() || position.isDiagonal()) {
					i++;
				}
				
				if(Position.DIAGONAL_FORWARD_RIGHT.equals(position) || Position.DIAGONAL_BACK_LEFT.equals(position)) {
					j--;
				}else if(position.isHorizontal() || position.isDiagonal()) {
					j++;
				}
				
				Coordinate coordinate = this.board.getCoordinate(minimum.getX() + i, minimum.getY() + j);
				if(coordinate.notEmpty()) {
					return false;
				}
				
			}while(i < max && j < max);
		}
		return true;
	}
	
	public void execute() {
		if(destination.containsKingOfOpponent(this.turn.getPlayer())) {
			this.turn.finish(this.movement);
		}else {
			this.origin.move(this.destination);
			this.turn.next(this.movement);
		}
	}
	
}
