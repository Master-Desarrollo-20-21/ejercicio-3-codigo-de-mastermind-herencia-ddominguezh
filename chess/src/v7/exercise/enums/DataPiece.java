package v7.exercise.enums;

public enum DataPiece {
	PAWN('\u2659', '\u265F'),
	ROOK('\u2656', '\u265C'),
	KNIGHT('\u2658', '\u265E'),
	BISHOP('\u2657', '\u265D'),
	QUEEN('\u2655', '\u265B'),
	KING('\u2654', '\u265A');
	private char white;
	private char black;
	
	DataPiece(char white, char black){
		this.white = white;
		this.black = black;
	}
	
	public char getName(boolean isWhite) {
		if(isWhite) {
			return this.white;
		}
		return this.black;
	}
}
