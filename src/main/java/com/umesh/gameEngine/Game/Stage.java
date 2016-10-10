package com.umesh.gameEngine.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.umesh.gameEngine.character.BaseCharacter;
import com.umesh.gameEngine.things.Item;

public class Stage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7783931471376862209L;
	
	int stageId;
	BaseCharacter systemCharcter;
	String stageDescription;
	String DangerMove;
	List<Item> itemList = new ArrayList<>();

	public Stage() {
		Random RG = new Random();
		int selectMove = RG.nextInt(3);
		switch (selectMove) {
		case 0:
			DangerMove = "LEFT";
			break;
		case 1:
			DangerMove = "FRONT";
			break;
		case 2:
			DangerMove = "RIGHT";
			break;
		default:
			System.out.println(" No move is danger move: " + selectMove);
			break;
		}

	}

	public String getDangerMoveOfThisStage() {
		return DangerMove;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public BaseCharacter getSystemCharcter() {
		return systemCharcter;
	}

	public void setSystemCharcter(BaseCharacter systemCharcter) {
		this.systemCharcter = systemCharcter;
	}

	public String getStageDescription() {
		return stageDescription;
	}

	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void addItemToList(Item item) {
		itemList.add(item);
	}

	@Override
	public String toString() {
		return "Stage [stageId=" + stageId + ", systemCharcter=" + systemCharcter + ", stageDescription="
				+ stageDescription + ", DangerMove=" + DangerMove + "]";
	}

}
