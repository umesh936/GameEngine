package com.umesh.gameEngine.commandImpl;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.utils.GameConstants;
import com.umesh.gameEngine.utils.Move;

public class FrontMovementCommand implements Command {

	public String executeAndRespond() throws ConfigurationInitializationException {
		if(!Game.getInstance().getGameState().getLastState().equals("WayOptions"))
			return "I am Afraid this is not a valid command at this point of time, please read instruction again."; 
		String dangerMove = Game.getInstance().getGameState().getCurrentStage().getDangerMoveOfThisStage();
		Move move = new Move();
		move.setMoveName(GameConstants.MoveConstant.FRONT);
		Game.getInstance().getGameState().getCurrentPlayer().addmoveTohistory(move);
		if (dangerMove.equals(GameConstants.MoveConstant.FRONT)) {
			move.setDangerMove();
			Game.getInstance().getGameState().setCurrentState("Battle");
			return "You just choose the tough way, Now you have problem to deal here";
		} else {
			Game.getInstance().getGameState().getCurrentPlayer().addNumberOfCoins(10);
			Game.getInstance().getGameState().currentStageClear();
			Game.getInstance().getGameState().setCurrentState("stageChanged");
			return "You have made the right decsion, there is no problem in this way have fun, food and beer. you will get 10 coins for this stage. But no experience gain."
					+ "you have jumped to next level. Choose wisely again there. good luck.";
		}
	}

}
