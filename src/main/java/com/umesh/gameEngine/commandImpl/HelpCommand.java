package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameCommands;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class HelpCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		StringBuffer buffer = new StringBuffer();
		for (GameCommands gc : GameCommands.values()) {
			if (gc.isAvailableToUser())
				buffer.append(gc.getCommandName() + "\t" + gc.getDescription()+"\n");
		}
		Game.getInstance().getGameState().setCurrentState("WaitUserInput");
		return buffer.toString();
	}

}
