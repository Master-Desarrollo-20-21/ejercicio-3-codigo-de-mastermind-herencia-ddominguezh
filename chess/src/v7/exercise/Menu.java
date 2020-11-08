package v7.exercise;

import v7.exercise.Console;
import v7.exercise.menu.Option;

public class Menu {

	protected Option[] options;
	public Menu() {

	}

	public void print() {
		print(this.options);
	}
	
	private void print(Option[] options) {
		Console.getInstance().write("CHESS MENU:");
		for(Option option : options) {
			option.print();
		}
		getAnswer(options);
	}
	
	private void getAnswer(Option[] options) {
		String answer;
		Option option;
		do {
			answer = Console.getInstance().readString("What option do you choose?: ");
			option = getOption(answer, options);
		} while(option == null);
		option.execute();
	}

	private Option getOption(String answer, Option[] options) {
		for(Option option : options) {
			if(option.equals(answer)){
				return option;
			}
		}
		return null;
	}
	
}
