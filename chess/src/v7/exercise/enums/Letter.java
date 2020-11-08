package v7.exercise.enums;

import v7.exercise.Console;

public enum Letter {
	A('A'),
	B('B'),
	C('C'),
	D('D'),
	E('E'),
	F('F'),
	G('G'),
	H('H');
	private char value;
	Letter(char value){
		this.value = value;
	}
	
	public static Letter valueOf(char chartAt) {
		for(Letter letter : Letter.values()) {
			if(letter.value == chartAt) {
				return letter;
			}
		}
		return null;
	}

	public static void print() {
		String value = "     ";
		for(Letter letter : Letter.values()) {
			value += letter.name() + "   ";
		}
		Console.getInstance().write(value);
	}
	
}
