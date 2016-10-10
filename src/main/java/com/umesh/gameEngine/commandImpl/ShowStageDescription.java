package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class ShowStageDescription implements Command{

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		Game.getInstance().getGameState().setCurrentState("WayOptions");
		StringBuffer buffer = new StringBuffer();
		buffer.append(Game.getInstance().getGameState().getCurrentStage().getStageDescription());
		buffer.append("\n");
		buffer.append(Game.getInstance().getGameState().getCurrentStage().getSystemCharcter().getDescription());
		return buffer.toString();
	}
	

}
