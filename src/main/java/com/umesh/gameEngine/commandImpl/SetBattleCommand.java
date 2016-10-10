package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.character.BaseCharacter;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;

/**
 * This class start the battle. 
 * 
 * @author umesh
 *
 */
public class SetBattleCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		BaseCharacter systemCharacter = Game.getInstance().getGameState().getCurrentStage().getSystemCharcter();
		System.out.println("Remember " + systemCharacter.getDescription());
		Game.getInstance().getGameState().setCurrentState("WaitUserInput");
		return "Type Attack to start the Fight.";
	}

}
