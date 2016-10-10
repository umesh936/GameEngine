package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class HealthCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		return "Player Health is " + Game.getInstance().getGameState().getCurrentPlayer().getCurrenthealth();
	}

}
