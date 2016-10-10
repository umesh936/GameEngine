package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.exception.ConfigurationInitializationException;

public interface Command {
	public String executeAndRespond() throws ConfigurationInitializationException;

}
