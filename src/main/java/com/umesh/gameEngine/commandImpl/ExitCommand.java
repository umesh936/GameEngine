package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.utils.GameConstants;

public class ExitCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		switch (Game.getInstance().getGameState().getCurrentState()) {
		case "Complete":
			return Game.getInstance().getExternalReader().getMessageForDisplay(GameConstants.CompleteMessage);
		case "Exception":
			return "Sorry for this internal issue raised. Help us to understand how can we make it better, mail @ umesh936@gmail.com";
		case "PlayerDied":
			return "Sorry Your Player Died, better Luck next time"; 
		default:
			return "You are in the middle of game. If you havn't save it yet,you will be going to loos your data.";
		}
	}

}
