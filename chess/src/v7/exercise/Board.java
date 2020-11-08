package v7.exercise;

import v7.exercise.enums.Letter;

public class Board {

	private static int BOARD_LENGTH = 8;
	private Coordinate[][] coordinates;

	public Board() {
		this.coordinates = new Coordinate[BOARD_LENGTH][BOARD_LENGTH];
		for(int i = 0 ; i < BOARD_LENGTH ; i++) {
			for(int j = 0 ; j < BOARD_LENGTH ; j++) {
				this.coordinates[i][j] = new Coordinate(i, j);
			}
		}
	}

	public Coordinate[] getRow(int x) {
		return this.coordinates[x];
	}
	
	public void print() {
		Letter.print();
		for(int i = 0 ; i < BOARD_LENGTH ; i++) {
			String line = (i + 1) + "  |";
			for(Coordinate coordiante : this.coordinates[i]) {
				line += " " + coordiante.print() + " |";
			}
			Console.getInstance().write(line);
			Console.getInstance().write("---|---|---|---|---|---|---|---|---|---");
		}
	}

	public Coordinate[] getCoordinates(String movement) {
		String[] part = movement.split(" at ");
		if(part.length == 2) {
			Coordinate origin = getBoardCoordinate(part[0]);
			Coordinate destination = getBoardCoordinate(part[1]);
			if(origin != null && destination != null) {
				return new Coordinate[] { origin, destination };
			}
		}
		return null;
	}
	
	private Coordinate getBoardCoordinate(String position) {
		int x = getRow(position.charAt(1));
		int y =  getColumn(position.charAt(0));
		if(isValidAxis(x) && isValidAxis(y)) {
			return this.getCoordinate(x, y);
		}
		return null;
	}
	
	private int getColumn(char charAt) {
		Letter letter = Letter.valueOf(charAt);
		if(letter != null) {
			return letter.ordinal();
		}
		return -1;
	}
	
	private int getRow(char charAt) {
		if(Character.isDigit(charAt)) {
			int number = Character.getNumericValue(charAt);
			if(number > 0 && number < 9) {
				return number - 1;
			}
		}
		return -1;
	}
	
	

	private boolean isValidAxis(int value) {
		return value >= 0 && value < BOARD_LENGTH;
	}
	
	public Coordinate getCoordinate(int x, int y) {
		return this.coordinates[x][y];
	}
	
}
