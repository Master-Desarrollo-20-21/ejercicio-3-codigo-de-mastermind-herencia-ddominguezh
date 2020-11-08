package v7.exercise;

import v7.exercise.menu.GiveUpOption;
import v7.exercise.menu.MoveOption;
import v7.exercise.menu.Option;

public class PlayMenu extends Menu{

	public PlayMenu(Turn turn, Board board) {
		options = new Option[2];
		options[0] = new MoveOption(turn, board);
		options[1] = new GiveUpOption(turn);
	}
}
