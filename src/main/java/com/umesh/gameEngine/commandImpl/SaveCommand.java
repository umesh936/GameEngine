package com.umesh.gameEngine.commandImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameConfiguration;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public final class SaveCommand implements Command {
	Scanner scanner = new Scanner(System.in);

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		try {
			System.out.println("Please Enter the Name to Store:\n>");
			String name = scanner.nextLine();
			while (true) {
				if (GameConfiguration.getLoadOldGamesName().contains(name))
					System.out.println("This Name is already there please try again!");
				else
					break;
			}
			FileOutputStream fos = new FileOutputStream(GameConfiguration.getGamePropertyMap().get("SAVE_PATH")
					+ GameConfiguration.getGameName() + File.separator + "savedGames" + File.separator + name + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Game.getInstance().getGameState());
			oos.close();
			fos.close();
			return "Game saved!";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
