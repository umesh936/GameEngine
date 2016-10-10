package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameConfiguration;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.utils.GameConstants;

public class StartCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {

		String message = Game.getInstance().getExternalReader()
				.getMessageForDisplay(GameConstants.StartMessage);
		if (message == null)
			return null;

		Game.getInstance().getGameState().setCurrentState("WaitUserInput");
		return message.replace("{name}", Game.getInstance().getGameState().getCurrentPlayer().getName())
				.replace("{totalStage}", GameConfiguration.getAvailableStages().size() + "");

	}

}
