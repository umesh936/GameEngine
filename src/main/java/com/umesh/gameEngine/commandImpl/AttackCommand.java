package com.umesh.gameEngine.commandImpl;

import java.util.Map;
import java.util.Random;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.character.BaseCharacter;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.externalReader.ExternalReader;

/**
 * Magic here to identify who will start here. Very simple logic, calculate
 * random number , if it is divisible by 2 then current stage monster will be
 * sleeping and user can hit else monster hit.
 * 
 * @author umesh
 *
 */
public class AttackCommand implements Command {
	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		if (!Game.getInstance().getGameState().getLastState().equals("Battle")) {
			return "I am Afraid this is not a valid command at this point of time, please read instruction again.";
		}
		BaseCharacter systemCharacter = Game.getInstance().getGameState().getCurrentStage().getSystemCharcter();
		BaseCharacter playerCharacter = Game.getInstance().getGameState().getCurrentPlayer();
		ExternalReader reader = Game.getInstance().getExternalReader();
		Map<String, String> battleMessageMap = reader.getPropertyMapFromEntity("BattleMessage");
		Random RG = new Random();
		playerCharacter.attack(systemCharacter);

		if (!systemCharacter.isAlive()) {
			playerCharacter.gainExperience();
			System.out.println("Hurray!! " + systemCharacter.getName() + " is dead. You can jump to next level now.");
			Game.getInstance().getGameState().currentStageClear();
			if (!Game.getInstance().getGameState().getCurrentState().equals("Complete"))
				Game.getInstance().getGameState().setCurrentState("stageChanged");
			return "";
		}
		while (true) {
			int selectAttackPlayer = RG.nextInt(20000);
			if (selectAttackPlayer % 2 == 0) {
				System.out.println("\n " + battleMessageMap.get("PlayerCanHit_" + (RG.nextInt(2) == 0 ? "1" : "2"))
						.replace("{name}", systemCharacter.getName()));
				Game.getInstance().getGameState().setCurrentState("WaitUserInput");
				break;
			} else {
				systemCharacter.attack(playerCharacter);
				if (!playerCharacter.isAlive()) {
					Game.getInstance().getGameState().setCurrentState("PlayerDied");
				}
			}
		}
		return "";
	}
}
