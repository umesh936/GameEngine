package com.umesh.gameEngine.processors;

import java.util.HashMap;
import java.util.Map;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameCommands;
import com.umesh.gameEngine.commandImpl.AttackCommand;
import com.umesh.gameEngine.commandImpl.Command;
import com.umesh.gameEngine.commandImpl.CreatePlayerCommand;
import com.umesh.gameEngine.commandImpl.DescribeCommand;
import com.umesh.gameEngine.commandImpl.DisplayeMessageCommand;
import com.umesh.gameEngine.commandImpl.ExitCommand;
import com.umesh.gameEngine.commandImpl.ExploreCommand;
import com.umesh.gameEngine.commandImpl.FrontMovementCommand;
import com.umesh.gameEngine.commandImpl.HealthCommand;
import com.umesh.gameEngine.commandImpl.HelpCommand;
import com.umesh.gameEngine.commandImpl.InvalidCommand;
import com.umesh.gameEngine.commandImpl.LeftMovementCommand;
import com.umesh.gameEngine.commandImpl.LookBackCommand;
import com.umesh.gameEngine.commandImpl.PlayCommand;
import com.umesh.gameEngine.commandImpl.PlayIntroCommand;
import com.umesh.gameEngine.commandImpl.ResumeCommand;
import com.umesh.gameEngine.commandImpl.RightMovementCommand;
import com.umesh.gameEngine.commandImpl.SaveCommand;
import com.umesh.gameEngine.commandImpl.SetBattleCommand;
import com.umesh.gameEngine.commandImpl.ShowStageDescription;
import com.umesh.gameEngine.commandImpl.StartCommand;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class GameCommandProcessor extends ResponseProcessor {
	private static Map<String, Command> commandMap = new HashMap<>();
	static {
		commandMap.put(GameCommands.HEALTH.toString(), new HealthCommand());
		commandMap.put(GameCommands.PLAYINTRO.toString(), new PlayIntroCommand());
		commandMap.put(GameCommands.EXIT.toString(), new ExitCommand());
		commandMap.put(GameCommands.CREATEPLAYER.toString(), new CreatePlayerCommand());
		commandMap.put(GameCommands.START.toString(), new StartCommand());
		commandMap.put(GameCommands.HELP.toString(), new HelpCommand());
		commandMap.put(GameCommands.SHOWOPTION.toString(), new DisplayeMessageCommand());
		commandMap.put(GameCommands.PLAY.toString(), new PlayCommand());
		commandMap.put(GameCommands.LOOKBACK.toString(), new LookBackCommand());
		commandMap.put(GameCommands.DESCME.toString(), new DescribeCommand());
		commandMap.put(GameCommands.LEFT.toString(), new LeftMovementCommand());
		commandMap.put(GameCommands.RIGHT.toString(), new RightMovementCommand());
		commandMap.put(GameCommands.FRONT.toString(), new FrontMovementCommand());
		commandMap.put(GameCommands.SAVE.toString(), new SaveCommand());
		commandMap.put(GameCommands.RESUME.toString(), new ResumeCommand());
		commandMap.put(GameCommands.EXPLORE.toString(), new ExploreCommand());
		commandMap.put(GameCommands.INVALID.toString(), new InvalidCommand());
		commandMap.put(GameCommands.SHOWSTAGEDESC.toString(), new ShowStageDescription());
		commandMap.put(GameCommands.ATTACK.toString(), new AttackCommand());
		commandMap.put(GameCommands.SETBATTLE.toString(), new SetBattleCommand());

	}

	public void processAndRepondeToUser(String command) {
		Command commandObject = commandMap.get(command);
		/*
		 * System.out.println("Processing Command : " + command);
		 * try{System.out.println("current stage : " +
		 * Game.getInstance().getGameState().getCurrentState());
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }
		 */
		String response;
		try {
			response = commandObject.executeAndRespond();
			if (response == null) {
				displayErrorMessage();
				Game.getInstance().getGameState().setCurrentState("Exception");
			} else {
				displayResponse(response);
			}
		} catch (ConfigurationInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

	}

}
