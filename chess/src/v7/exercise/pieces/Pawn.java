package v7.exercise.pieces;

import v7.exercise.Coordinate;
import v7.exercise.Player;
import v7.exercise.enums.DataPiece;
import v7.exercise.enums.Position;

public class Pawn extends Piece{

	//PEON
	public Pawn(Player player) {
		super(player, DataPiece.PAWN);
	}

	@Override
	public boolean canMove(Coordinate origin, Coordinate destination) {
		Position position = origin.getPosition(destination);
		int distance = origin.distance(destination);
		if(destination.containsPieceOfOpponent(this.player)) {
			return distance == 1 && ((this.player.isWhite() && position.isDiagonalForward()) 
					|| (!this.player.isWhite() && position.isDiagonalBack()));
		}
		if(distance == 1 || (distance == 2 && this.initialPosition)) {
			return ((this.player.isWhite() && Position.VERTICAL_FORWARD.equals(position)) || 
					(!this.player.isWhite() && Position.VERTICAL_BACK.equals(position)));
		}
		return false;
	}
	
}
