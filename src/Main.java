import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;
import java.util.Random;


public class Main {
	public static void main(String[] args) throws InterruptedException {

		Terminal terminal = TerminalFacade.createTerminal(System.in,
				System.out, Charset.forName("UTF8"));

		Player player1 = new Player(49, 15);
		Monster[] monsterArray = new Monster[4];
		monsterArray[0] = new Monster(1, 1);
		monsterArray[1] = new Monster(99, 1);
		monsterArray[2] = new Monster(1, 29);
		monsterArray[3] = new Monster(99, 29);
		Key key = terminal.readInput();

		terminal.enterPrivateMode();
		terminal.applyForegroundColor(0, 255, 0);
		terminal.setCursorVisible(false);

		displayStartScreen(terminal, key);


		while(true) {
			getKeyPress(key, terminal, player1, monsterArray);

		}
	}

	public static void displayStartScreen(Terminal terminal, Key key) throws InterruptedException {

		for (int z = 0; z < 49; z++) {
			printText(z,  15, "LET'S PLAY AVA", terminal);
			printText(z - 40,  2, "LET'S PLAY AVA", terminal);
			printText(z - 20,  8, "LET'S PLAY AVA", terminal);
			printText(z + 20,  22, "LET'S PLAY AVA", terminal);
			Thread.sleep(100);
			terminal.clearScreen();
		}

		for (int i = 3; i > 0; i--) {
			//do {
				//Thread.sleep(1000);
				printText(49, 15, "Ready? " + i, terminal);
				Thread.sleep(1000);
				key = terminal.readInput();

			//} while (key == null);
		}

		terminal.clearScreen();
		printText(49, 15, "GO!", terminal);
		Thread.sleep(1000);
	}

	public static void getKeyPress(Key key, Terminal terminal, Player player, Monster[] monsterArray) throws InterruptedException {

		do{

			Thread.sleep(100);
			terminal.clearScreen();
			key = terminal.readInput();
			drawBorder(terminal);
			player.drawCharacter(terminal);
			monsterArray[0].drawMonster(terminal);
			moveMonsterCloserToPlayer(key, player, monsterArray[0], terminal,  monsterArray);
			monsterArray[1].drawMonster(terminal);
			moveMonsterCloserToPlayer( key, player, monsterArray[1], terminal, monsterArray);
			monsterArray[2].drawMonster(terminal);
			moveMonsterCloserToPlayer(key, player, monsterArray[2], terminal, monsterArray);
			monsterArray[3].drawMonster(terminal);
			moveMonsterCloserToPlayer(key, player, monsterArray[3], terminal, monsterArray);


			if (player.shouldPlayerDie()) {
				player.playerDies(terminal);
			}


		} while(key == null);

		System.out.println(key.getCharacter()+ " " + key.getKind());

		switch(key.getKind())
		{
			case ArrowDown:
				player.movePlayerDown(terminal);
				break;
			case ArrowUp:
				player.movePlayerUp(terminal);
				break;
			case ArrowLeft:
				player.movePlayerLeft(terminal);
				break;
			case ArrowRight:
				player.movePlayerRight(terminal);
				break;
		}
	}

	public static void printText(int x, int y, String message, Terminal terminal) {

			for (int i = 0; i < message.length(); i++) {
				terminal.moveCursor(x, y);
				terminal.putCharacter(message.charAt(i));
				x = x + 1;
			}
		}

	public static void moveMonsterCloserToPlayer( Key key, Player player, Monster monster, Terminal terminal, Monster[] monsterArray)
		throws InterruptedException {

		Random randomizer = new Random();
		int randomInt = randomizer.nextInt(2);

		if (monster.x < player.x) {
			monster.x += randomInt;
		} else if (monster.x > player.x){
			monster.x -= randomInt;
		}

		if (monster.y < player.y) {
			monster.y += randomInt;
		} else if (monster.y > player.y) {
			monster.y -= randomInt;
		}

		if (monster.x == player.x && monster.y == player.y) {
				player.playerDies(terminal);

		}

	}

	public static void drawBorder(Terminal terminal) {
		for (int i = 0; i < 100; i++) {
			terminal.moveCursor(i, 0);
			terminal.putCharacter('|');
		}

		for (int i = 0; i < 100; i++) {
			terminal.moveCursor(0, i);
			terminal.putCharacter('|');
		}

		for (int i = 0; i < 100; i++) {
			terminal.moveCursor(i, 30);
			terminal.putCharacter('|');
		}

		for (int i = 0; i < 100; i++) {
			terminal.moveCursor(100, i);
			terminal.putCharacter('|');
		}
	}


}
