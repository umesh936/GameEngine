package com.umesh.gameEngine.commandImpl;

import java.util.List;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.exception.ConfigurationInitializationException;
import com.umesh.gameEngine.things.Item;

public class ExploreCommand implements Command {

	@Override
	public String executeAndRespond() throws ConfigurationInitializationException {
		StringBuffer sb = new StringBuffer();
		List<Item> itemList = Game.getInstance().getGameState().getCurrentStage().getItemList();
		sb.append("If you look around, you find following things in this stage.\n");
		for (Item item : itemList) {
			sb.append(item.getName());
			sb.append("\n");
		}
		sb.append("\nFor this particular version of game, player can not grab anything from here."
				+ " May be in next version we will have grab command.");
		return sb.toString();
	}

}
