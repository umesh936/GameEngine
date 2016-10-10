package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public class InvalidCommand implements Command{

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		return "You have entered some invalid command, please read the instruction carefully.";
	}

}
