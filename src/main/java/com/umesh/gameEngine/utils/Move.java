package com.umesh.gameEngine.utils;

import java.io.Serializable;

/**
 * This class is an entity in storing the history of player. WE can show a
 * lining map in
 * 
 * @author umesh
 *
 */
public class Move implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705709998206010233L;
	
	private String moveName;
	private boolean wasDangerMove;
	private String visiualDirection;
	private int locationFactor;

	public Move() {
		setSafeMove();
	}

	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
		switch (moveName) {
		case GameConstants.MoveConstant.LEFT:
			this.visiualDirection = GameConstants.MoveConstant.DISPLAY_LEFT;
			this.locationFactor = -1;
			break;
		case GameConstants.MoveConstant.FRONT:
			this.visiualDirection = GameConstants.MoveConstant.DISPLAY_FRONT;
			this.locationFactor = 0;
			break;

		case GameConstants.MoveConstant.RIGHT:
			this.visiualDirection = GameConstants.MoveConstant.DISPLAY_RIGHT;
			this.locationFactor = 1;
			break;
		default:
			break;
		}
	}

	public boolean isWasDangerMove() {
		return wasDangerMove;
	}

	public void setDangerMove() {
		this.wasDangerMove = true;
	}

	public void setSafeMove() {
		this.wasDangerMove = false;
	}

	public String getVisiualDirection() {
		return visiualDirection;
	}

	public void setVisiualDirection(String visiualDirection) {
		this.visiualDirection = visiualDirection;
	}

	public int getLocationFactor() {
		return locationFactor;
	}

	public void setLocationFactor(int locationFactor) {
		this.locationFactor = locationFactor;
	}

}
