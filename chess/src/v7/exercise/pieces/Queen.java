package v7.exercise.pieces;

import v7.exercise.Coordinate;
import v7.exercise.Player;
import v7.exercise.enums.DataPiece;
import v7.exercise.enums.Position;

public class Queen extends Piece {

	//DAMA
	public Queen(Player player) {
		super(player, DataPiece.QUEEN);
	}

	@Override
	public boolean canMove(Coordinate origin, Coordinate destination) {
		Position position = origin.getPosition(destination);
		if(!Position.L_SHAPE.equals(position)) {
			return true;
		}
		return false;
	}
	
}
