package com.umesh.gameEngine.logger;

/**
 * Any developer want to raise any event could be log could be alert send to
 * queue or any use he can thing of can implement this interface.
 * For now I am using this only for logging.
 * @author umesh
 *
 */
public interface GameEventInterface {

	public void sendEvent(GameEventType event, String message);

}
