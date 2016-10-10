package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class PlayCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		Game.getInstance().getGameState().currentStageClear();
		Game.getInstance().getGameState().setCurrentState("stageChanged");
		return "";
	}

}
