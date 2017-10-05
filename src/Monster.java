import com.googlecode.lanterna.terminal.Terminal;


public class Monster {
	public int x;
	public int y;


	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void monsterClearScreen(Terminal terminal) {
		terminal.clearScreen();
	}

	public void moveMonsterUp(Terminal terminal) {
		terminal.moveCursor((int)x,(int)y - 1);
		terminal.putCharacter('X');
		System.out.println(x + " " + y);
		y = y - 1;
	}

	public void moveMonsterDown(Terminal terminal) {
		terminal.moveCursor((int)x,  (int)y + 1);
		terminal.putCharacter('X');
		System.out.println(x + " " + y);
		y = y + 1;
	}

	public void moveMonsterRight(Terminal terminal) {
		terminal.moveCursor((int) x + 1, (int) y );
		terminal.putCharacter('X');
		System.out.println(x + " " + y);
		x = x + 1;
	}

	public void moveMonsterLeft(Terminal terminal) {
		terminal.moveCursor((int) x - 1,  (int) y );
		terminal.putCharacter('X');
		System.out.println(x + " " + y);
		x = x - 1;
	}

	public void drawMonster (Terminal terminal) {
		// terminal.moveCursor((int) x, (int) y);
		// terminal.putCharacter('X');
		printText((int) x, (int) y, "♎", terminal );
		terminal.moveCursor(0,0);
	}

	public static void printText(int x, int y, String message, Terminal terminal) {

		for (int i = 0; i < message.length(); i++) {
			terminal.moveCursor(x, y);
			terminal.putCharacter(message.charAt(i));
			x = x + 1;
		}
	}
}
