package com.umesh.gameEngine.things;

/**
 * Item Placed in current Chamber.
 * @author umesh
 *
 */
public interface Item {
 	
	String getName();
	String getDescription();
	Boolean canPlayerGetThis();
	Boolean isWeapon();
	
}
