package com.umesh.gameEngine.commandImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameConfiguration;
import com.umesh.gameEngine.Game.GameState;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class ResumeCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		Scanner scanner = new Scanner(System.in);
		if (!Game.getInstance().getGameState().getCurrentState().equals("IntroPlayed")) {
			return "I am afraid this is not availd command at this step";
		}
		System.out.println("If you have any save game you can Load that game also else You can Type ECS "
				+ "\nEnter your Saved Game Name :");
		while (true) {
			String gameName = scanner.nextLine();
			if (gameName.equalsIgnoreCase("esc")) {
				Game.getInstance().getGameState().setCurrentState("CheckedRestore");
				return "";
			}
			if (!GameConfiguration.getLoadOldGamesName().contains(gameName)) {
				System.out.println("There is no game saved with this name.Try again! or you can type "
						+ "ESC to start with new player.");
			} else {
				GameState resumeState = null;
				try {
					FileInputStream fis = new FileInputStream(
							GameConfiguration.getGamePropertyMap().get("SAVE_PATH") + GameConfiguration.getGameName()
									+ File.separator + "savedGames" + File.separator + gameName + ".ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					resumeState = (GameState) ois.readObject();
					ois.close();
					Game.getInstance().ResumeGame(resumeState);
					StringBuffer sb = new StringBuffer();
					createGameSummary(sb, resumeState);
					System.out.println("Please Enter RESUME to start the game, any thing else will be ");
					while (true) {
						if (!scanner.nextLine().equals("RESUME")) {
							System.out.println("This is not a Valid command.");
						} else
							break;
					}
					return sb.toString();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}

			}
		}

	}

	private void createGameSummary(StringBuffer sb, GameState state) throws ConfigurationInitializationException {
		// System.out.println(state);
		if (state.getCurrentState().equals("PlayerCreated")) {
			sb.append("You have choosen the player " + state.getCurrentPlayer().getName()
					+ "\n please carry on from here.");
		}
		if (state.getCurrentState().equals("stageChanged") || state.getCurrentState().equals("WayOptions")
				|| state.getCurrentState().equals("Battle") || state.getCurrentState().equals("WaitUserInput")) {
			sb.append("\nYou were in the middle of the game, Below are the detail.\n");
			sb.append("You are " + state.getCurrentPlayer().getName()
					+ " in this game.\n Please use DESCME command to see your health and weapons.");
			sb.append("You were at stage : stage" + state.getCurrentStage().getStageId() + "\n");
			sb.append("In this stage your Enmy is " + state.getCurrentStage().getSystemCharcter().getName() + "\n");
			if (state.getCurrentState().equals("WaitUserInput")) {
				Game.getInstance().getGameState().setCurrentState(state.getLastState());
			}
		}
	}
}
