package v7.exercise.enums;

public enum Position {
	VERTICAL_FORWARD,
	VERTICAL_BACK,
	HORIZONTAL_RIGHT,
	HORIZONTAL_LEFT,
	DIAGONAL_FORWARD_LEFT,
	DIAGONAL_FORWARD_RIGHT,
	DIAGONAL_BACK_LEFT,
	DIAGONAL_BACK_RIGHT,
	L_SHAPE;

	public static Position valueOf(int compareX, int compareY) {
		if(compareY == 0 && compareX < 0) {
			return Position.VERTICAL_FORWARD;
		}
		if(compareY == 0 && compareX > 0) {
			return Position.VERTICAL_BACK;
		}
		if(compareX == 0 && compareY < 0) {
			return Position.HORIZONTAL_RIGHT;
		}
		if(compareX == 0 && compareY > 0) {
			return Position.HORIZONTAL_LEFT;
		}
		if(Math.abs(compareX) == Math.abs(compareY) && compareX < 0 && compareY < 0) {
			return Position.DIAGONAL_FORWARD_LEFT;
		}
		if(Math.abs(compareX) == Math.abs(compareY) && compareX < 0 && compareY > 0) {
			return Position.DIAGONAL_FORWARD_RIGHT;
		}
		if(Math.abs(compareX) == Math.abs(compareY) && compareX > 0 && compareY < 0) {
			return Position.DIAGONAL_BACK_LEFT;
		}
		if(Math.abs(compareX) == Math.abs(compareY) && compareX > 0 && compareY > 0) {
			return Position.DIAGONAL_BACK_RIGHT;
		}
		if((Math.abs(compareX) == 1 &&
				Math.abs(compareY) == 2) || 
				(Math.abs(compareX) == 2 &&
				Math.abs(compareY) == 1)) {
			return Position.L_SHAPE;
		}
		return null;
	}

	public boolean isVertical() {
		return Position.VERTICAL_FORWARD.equals(this) || Position.VERTICAL_BACK.equals(this);
	}

	public boolean isHorizontal() {
		return Position.HORIZONTAL_LEFT.equals(this) || Position.HORIZONTAL_RIGHT.equals(this);
	}
	
	public boolean isDiagonal() {
		return isDiagonalForward() ||isDiagonalBack();
	}

	public boolean isDiagonalForward() {
		return Position.DIAGONAL_FORWARD_LEFT.equals(this) || Position.DIAGONAL_FORWARD_RIGHT.equals(this);
	}
	
	public boolean isDiagonalBack() {
		return Position.DIAGONAL_BACK_LEFT.equals(this) || Position.DIAGONAL_BACK_RIGHT.equals(this);
	}
	
	public boolean isMinor() {
		return Position.VERTICAL_FORWARD.equals(this) || Position.HORIZONTAL_RIGHT.equals(this) || Position.DIAGONAL_FORWARD_LEFT.equals(this) || Position.DIAGONAL_FORWARD_RIGHT.equals(this);
	}
	
}
