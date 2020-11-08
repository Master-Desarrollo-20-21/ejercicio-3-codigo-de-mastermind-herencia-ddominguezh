package v7.exercise;

import v7.exercise.menu.FinishOption;
import v7.exercise.menu.Option;
import v7.exercise.menu.PlayOption;

public class MainMenu extends Menu{

	public MainMenu(Chess chess) {
		options = new Option[2];
		options[0] = new PlayOption(chess);
		options[1] = new FinishOption();
	}

}
