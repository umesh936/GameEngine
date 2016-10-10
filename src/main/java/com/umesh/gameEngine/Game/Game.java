package com.umesh.gameEngine.Game;

import java.util.Map;

import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.externalReader.ExternalReader;
import com.umesh.gameEngine.logger.GameEventInterface;
import com.umesh.gameEngine.utils.GameConstants;

/**
 * Single Instance of Game will be there in One Player, I am not adding thread
 * safe here, as I am not dealing with multipleyer game for now.
 * 
 * @author umesh
 *
 */

public class Game {
	private static Game game = null;
	private ExternalReader externalReaderForConf;
	private GameEventInterface EventHandler;
	private Map<String, String> ruleMap;

	GameState state = new GameState();

	private Game(ExternalReader externalReader) {
		this.externalReaderForConf = externalReader;
	}

	private boolean loadRules() {
		ruleMap = externalReaderForConf.getPropertyMapFromEntity(GameConstants.RuleEngineProperty);
		if (ruleMap == null)
			return false;
		return true;
	}

	public static Game getInstance() throws ConfigurationInitializationException {
		if (game == null) {
			throw new ConfigurationInitializationException("Game not initalized Properly");
		} else {
			return game;
		}
	}

	public static Game getInstance(ExternalReader externalReader) {
		if (game == null) {
			game = new Game(externalReader);
		}
		return game;
	}
	public void ResumeGame(GameState resumeState){
		state = resumeState;
	}

	public GameEventInterface getEventHandler() {
		return EventHandler;
	}

	public void setEventHandler(GameEventInterface eventHandler) {
		EventHandler = eventHandler;
	}

	public boolean initialize() {
		GameConfiguration.loadConfiguration(externalReaderForConf);
		loadRules();
		return true;

	}

	public String getNextCommand() {
		return ruleMap.get(state.getCurrentState());
	}

	public GameState getGameState() {
		return state;
	}

	public ExternalReader getExternalReader() {
		return externalReaderForConf;
	}

}
