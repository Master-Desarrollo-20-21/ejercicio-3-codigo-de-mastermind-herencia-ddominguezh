package v5.exercise.enums;

public enum Color {
	RED('r'),
    	BLUE('b'),
    	GREEN('g'),
    	YELLOW('y'),
    	PINK('p'),
    	MAGENTE('m'),
    	ORANGE('o'),
    	SILVER('s');
    	private char shortName;
    	Color(char shortName) {
    		this.shortName = shortName;
    	}
	public static Color valueOf(char value) {
		for(Color color : Color.values()) {
			if(color.shortName == value) {
				return color;
			}
		}
		return null;
	}
	public char shortName() {
		return this.shortName;
	}
	public static String shortNames() {
		String result = "";
		for(Color color : Color.values()) {
			result += color.shortName();
		}
		return result;
	}
}
