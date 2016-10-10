package com.umesh.gameEngine.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.umesh.gameEngine.utils.Move;

/**
 * Different then bad character, Can increase the health, Explore the room, Get
 * new weapon, Can collect the coins
 * 
 * @author umesh
 *
 */
public class PlayerCharacter extends BaseCharacter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079594925978276884L;
	private List<Move> moveHistory = new ArrayList<>();
	private int numberOfCoins = 10;

	public PlayerCharacter(String name) {
		this.name = name;
	}

	public int getNumberOfCoins() {
		return numberOfCoins;
	}

	public void addNumberOfCoins(int numberOfCoins) {
		this.numberOfCoins += numberOfCoins;
	}

	public void addmoveTohistory(Move move) {
		moveHistory.add(move);
	}

	public List<Move> getMoveHistory() {
		return moveHistory;
	}

	@Override
	public String toString() {
		return super.toString() + "\n     numberOfCoin:  " + numberOfCoins;
	}

}
