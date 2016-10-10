package com.umesh.gameEngine.Game;

import java.io.Serializable;

import com.umesh.gameEngine.character.BaseCharacter;
import com.umesh.gameEngine.character.PlayerCharacter;

/**
 * This class is used to support Current Game State.
 * 
 * @author umesh
 *
 */
public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024099838781056657L;

	private PlayerCharacter currentPlayer;
	private String currentState = "Loaded";
	private String lastState = "Loaded";
	private Stage currentStage;

	public PlayerCharacter getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean loadCurrentPlayer(String playerName) {
		BaseCharacter player = GameConfiguration.loadCharacterWithName(playerName, false);
		if (player == null)
			return false;
		else
			currentPlayer = (PlayerCharacter) player;
		return true;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String newCurrentState) {
		if (newCurrentState.equals(this.currentState))
			return;
		setLastState(this.currentState);
		this.currentState = newCurrentState;
	}

	public Stage getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(Stage currentStage) {
		this.currentStage = currentStage;
	}

	public String getLastState() {
		return lastState;
	}

	public void setLastState(String lastState) {
		this.lastState = lastState;
	}

	public void currentStageClear() {
		try {
			currentStage = GameConfiguration.getNextStage(currentStage);
		} catch (IndexOutOfBoundsException e) {
			// It means we are at last stage. change the current state to
			// complete.
			currentState = "Complete";
		}
	}

	@Override
	public String toString() {
		return "GameState [currentPlayer=" + currentPlayer + ", currentState=" + currentState + ", lastState="
				+ lastState + ", currentStage=" + currentStage + "]";
	}

}
