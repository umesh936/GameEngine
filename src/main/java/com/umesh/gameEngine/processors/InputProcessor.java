package com.umesh.gameEngine.processors;

import com.umesh.gameEngine.Game.GameCommands;

public class InputProcessor {
	ResponseProcessor commandProcessor = new GameCommandProcessor();
	ResponseProcessor userActionProcessor = new UserActionProcessor();
		
	public void processCommand(String keyword){
		try{if (GameCommands.isValidCommand(keyword.trim())) {
			executeCommand(keyword);
		}else{
			executeUserEnteredCommand(keyword);
		}}catch (IllegalArgumentException e) {
			executeCommand(GameCommands.INVALID.toString());
		}
	}
	
	private void executeCommand(String command) {
		commandProcessor.processAndRepondeToUser(command);
	}

	private void executeUserEnteredCommand(String keyword){
		userActionProcessor.processAndRepondeToUser(keyword);
	}
}

