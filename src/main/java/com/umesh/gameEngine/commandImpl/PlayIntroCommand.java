package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.utils.GameConstants;

public class PlayIntroCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		String message = Game.getInstance().getExternalReader().getMessageForDisplay(GameConstants.IntroMessage);
		Game.getInstance().getGameState().setCurrentState("IntroPlayed");
		return message;
	}
}
