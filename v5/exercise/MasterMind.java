package v5.exercise;

public class MasterMind {

	private Game game;
	public MasterMind() {
		this.game = new Game();
	}
	public void play() {
		do {
			this.game.play();
		}while(this.isResume());
	}
	public boolean isResume() {
		String answer;
		do
			answer = Console.getInstance().readString("Do you want to play again? (Y/N): ");
		while(!"Y".equalsIgnoreCase(answer) && !"N".equalsIgnoreCase(answer));
		return "Y".equalsIgnoreCase(answer);
	}
	public static void main(String[] args) {
		new MasterMind().play();
	}
}
