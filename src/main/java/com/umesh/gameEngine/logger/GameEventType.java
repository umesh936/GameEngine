package com.umesh.gameEngine.logger;

/**
 * For now we are using event just to log into the file. When it become
 * mutli player game then we can use event to publish to any topic on cloud.
 * 
 * @author umesh
 * Only LOG is in User For Now.
 */
public enum GameEventType {
	LOG, USERACTION, ALERT;
}
