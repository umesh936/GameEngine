package com.umesh.gameEngine.commandImpl;

import java.util.List;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.utils.Move;

public class LookBackCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		List<Move> movehistory = Game.getInstance().getGameState().getCurrentPlayer().getMoveHistory();
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nYou started from here.");
		addFullLineInMap(buffer, movehistory.size());
		int currentLocation = movehistory.size() * 2;
		for (Move move : movehistory) {
			fillSpaceTill(currentLocation,buffer);
			buffer.append("*");
			fillSpaceTill(currentLocation,buffer);
			buffer.append("|");
			currentLocation = currentLocation + move.getLocationFactor();
			fillSpaceTill(currentLocation,buffer);
			buffer.append(move.getVisiualDirection());
		}
		addFullLineInMap(buffer, movehistory.size());	
		buffer.append("\nYou are currently here now.");
		return buffer.toString();
	}

	public void addFullLineInMap(StringBuffer buffer, int totalMoveTillNow) {
		buffer.append("\n");
		for (int i = 0; i < totalMoveTillNow * 2; i++) {
			System.out.println("_");
		}
	}
	private void fillSpaceTill(int count,StringBuffer buffer){
		buffer.append("\n");
		for (int j = 0; j < count; j++) {
			buffer.append("  ");
		}
	}

}
