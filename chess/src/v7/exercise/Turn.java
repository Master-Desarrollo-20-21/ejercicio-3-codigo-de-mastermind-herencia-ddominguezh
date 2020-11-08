package v7.exercise;

public class Turn {

	private Chess chess;
	private Player player;
	private PlayMenu menu;
	
	public Turn(Chess chess, Player player, Board board) {
		this.chess = chess;
		this.menu = new PlayMenu(this, board);
		this.player = player;
	}

	public void start() {
		Console.getInstance().write("Turn " + this.player.name());
		this.menu.print();
	}
	
	public void giveUp() {
		Console.getInstance().write(this.player.name() + " Loose");
		this.chess.init();
	}

	public void change(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void next(String movement) {
		this.player.add(movement);
		this.chess.next(this.player);
	}
	
	public void finish(String movement) {
		this.player.add(movement);
		Console.getInstance().write(this.player.name() + " Win");
		this.chess.finish();
	}

}
