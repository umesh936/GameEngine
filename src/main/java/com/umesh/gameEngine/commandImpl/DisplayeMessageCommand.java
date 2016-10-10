package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class DisplayeMessageCommand implements Command{

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		String message = Game.getInstance().getExternalReader().getMessageForDisplay(Game.getInstance().getGameState().getCurrentState());
		if(message!=null){
			Game.getInstance().getGameState().setCurrentState("WaitUserInput");
		}
		return message;
	}

}
