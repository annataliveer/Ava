import com.googlecode.lanterna.terminal.Terminal;

public class Player {
	public int x;
	public int y;
	public int livesLeft = 2;
	private int UPPER_BOUND;
	private int LOWER_BOUND;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.livesLeft = livesLeft;
	}


	public void playerClearScreen(Terminal terminal) {
		terminal.clearScreen();
	}

	public void movePlayerRight(Terminal terminal) {
		terminal.moveCursor(x + 2, y);
		terminal.putCharacter('>');
		System.out.println(x + " " + y);
		x = x + 2;

	}

	public void movePlayerLeft(Terminal terminal) {
		terminal.moveCursor(x - 2, y);
		terminal.putCharacter('<');
		System.out.println(x + " " + y);
		x = x - 2;

	}

	public void movePlayerUp(Terminal terminal) {
		terminal.moveCursor(x, y - 2);
		terminal.putCharacter('^');
		System.out.println(x + " " + y);
		y = y - 2;

	}

	public void movePlayerDown(Terminal terminal) {
		terminal.moveCursor(x, y + 2);
		terminal.putCharacter('v');
		System.out.println(x + " " + y);
		y = y + 2;

	}


	public void drawCharacter (Terminal terminal) {
		terminal.moveCursor(x, y);
		terminal.putCharacter('O');
		terminal.moveCursor(0, 0);
	}

	public boolean shouldPlayerDie() {
		if (x <= 0 || x >= 99 || y <= 1 || y >= 29) {
			return true;
		} else {
			return false;
		}
	}

	public void playerDies (Terminal terminal) throws InterruptedException {

		terminal.clearScreen();
		Main.printText(45, 15, "GAME OVER.", terminal);
		Thread.sleep(5000);
		terminal.exitPrivateMode();

	}



}
