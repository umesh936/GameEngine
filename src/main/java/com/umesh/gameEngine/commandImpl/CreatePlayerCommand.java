package com.umesh.gameEngine.commandImpl;

import java.util.Scanner;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class CreatePlayerCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException{
		System.out.println("\nPlease Select the Role you want for your player.");
		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		String playername = scanner.nextLine();
		while(!Game.getInstance().getGameState().loadCurrentPlayer(playername)){
			System.out.println(" I am afraid  this character is not available. Please choose from above mention character.");
			System.out.print(">");
			playername = scanner.nextLine();
		}
		
		Game.getInstance().getGameState().setCurrentState("PlayerCreated");
		return "player Created Successfully!";
	}

}
