package com.umesh.gameEngine.things;

import java.io.Serializable;

/**
 * This is entity can be find in any stage, when player shoot the explore
 * command then he will be able to see items present in the stage. This could be
 * lamp, food, paper (which has some hint to clear the stage).
 * 
 * @author umesh
 *
 */
public class DisplayableItems implements Item,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5203876486651705844L;
	
	private String name;
	private String description;

	public DisplayableItems(String name) {
		this.name = name;
		this.description = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Boolean canPlayerGetThis() {
		return false;
	}

	@Override
	public Boolean isWeapon() {
		return false;
	}

}
