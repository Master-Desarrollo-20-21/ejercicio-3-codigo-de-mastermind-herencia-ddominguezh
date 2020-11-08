package v7.exercise;

import java.util.ArrayList;
import java.util.List;

import v7.exercise.enums.Color;
import v7.exercise.pieces.Bishop;
import v7.exercise.pieces.King;
import v7.exercise.pieces.Knight;
import v7.exercise.pieces.Pawn;
import v7.exercise.pieces.Queen;
import v7.exercise.pieces.Rook;

public class Player {

	private Color color;
	private List<String> movements;
	
	public Player(Color color, Coordinate[] lastRow, Coordinate[] pawnRow) {
		this.color = color;
		this.movements = new ArrayList<String>();
		for( int i = 0 ; i < pawnRow.length ; i++ ) {
			pawnRow[i].add(new Pawn(this));
		}
		lastRow[0].add(new Rook(this));
		lastRow[1].add(new Knight(this));
		lastRow[2].add(new Bishop(this));
		lastRow[3].add(new Queen(this));
		lastRow[4].add(new King(this));
		lastRow[5].add(new Bishop(this));
		lastRow[6].add(new Knight(this));
		lastRow[7].add(new Rook(this));
	}
	
	public boolean isWhite() {
		return Color.WHITE.equals(this.color);
	}
	
	public String name() {
		return this.color.name();
	}
	
	public void add(String movement) {
		this.movements.add(movement);
	}
	
}
