package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class DescribeCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		return Game.getInstance().getGameState().getCurrentPlayer().toString();

	}

}
