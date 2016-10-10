package com.umesh.gameEngine;

import java.util.Scanner;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameCommands;
import com.umesh.gameEngine.externalReader.ExternalReader;
import com.umesh.gameEngine.externalReader.ExternalReaderFromFilles;
import com.umesh.gameEngine.logger.LogEvent;
import com.umesh.gameEngine.processors.InputProcessor;

public class Launcher {

	public static void main(String[] args) {

		InputProcessor inputprocessor = new InputProcessor();
		ExternalReader externalReader = new ExternalReaderFromFilles();
		Game game = Game.getInstance(externalReader);
		Scanner scanner = new Scanner(System.in);
		game.setEventHandler(new LogEvent());
		if (!game.initialize()) {
			System.out.println("SORRY!! Not able to initalize the Game. Please Try Another Game.");
			System.exit(1);
		}

		String nextCommand = game.getNextCommand();

		while (!nextCommand.equalsIgnoreCase("EXIT")) {
			inputprocessor.processCommand(nextCommand);
			if (game.getGameState().getCurrentState().equals("WaitUserInput")) {
				nextCommand = scanner.nextLine().toUpperCase();
			} else {
				nextCommand = game.getNextCommand();
			}
		}
		inputprocessor.processCommand(GameCommands.EXIT.getCommandName());
	}

}
