package com.umesh.gameEngine.Game;
/**
 * Enum to hold all the available command for the Game.
 * @author umesh
 *
 */
public enum GameCommands {

	/*
	 * CommandName, Is Available To User, Description
	 */
	
	SAVE("SAVE", true, "To save Game state at any point of time"), 
	EXIT("EXIT", true, "To exit from game"), 
	HELP("HELP",true, "To show help at any point of time"), 
	HEALTH("HEALTH", true, "To check the health of user at any point of time"),
	EXPLORE("EXPLORE", true,"To explore the items available in current stage."),
	LOOKBACK("LOOKBACK", true,"To look back the path where you have reached."),
	DESCME("DESCME",true,"To see the your own power, weapon bag, coin etc."),
	LEFT("LEFT",true,"To Select the Left Way"),
	RIGHT("RIGHT",true,"To Select the Right Way"),
	FRONT("FRONT",true,"To Select the Front Way"),
	SELWEAPON("SELWEAPON",true,"To Select Current Weapon you want to carry."),
	ATTACK("ATTACK",true,"To attack the opponent with selected Weapon"),
	START("START", false, "Internal System Command"), 
	LOADWEAPON("LOADWEAPON",false,"Internal System Command"),
	CREATEPLAYER("CREATEPLAYER",false,"Internal System Command"),
	USERINPUT("USERINPUT",false,"Internal System Command"),
	SHOWOPTION("SHOWOPTION",false,"Internal System Command"),
	SETBATTLE("SETBATTLE",false,"Internal System Command"),
	PLAY("PLAY",false,"Internal System Command"),
	RESUME("RESUME",false,"Internal System Command"),
	INVALID("INVALID",false,"Internal System Command"),
	SHOWSTAGEDESC("SHOWSTAGEDESC",false,"Internal System Command"),
	PLAYINTRO("PLAYINTRO", false, "Internal System Command");

	private String commandName;
	private boolean isAvailableToUser;

	private String description;

	GameCommands(String name, boolean isAvailableToUser, String description) {
		this.commandName = name;
		this.isAvailableToUser = isAvailableToUser;
		this.description = description;
	}

	public String getCommandName() {
		return this.commandName;
	}

	public boolean isAvailableToUser() {
		return isAvailableToUser;
	}

	public void setAvailableToUser(boolean isAvailableToUser) {
		this.isAvailableToUser = isAvailableToUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static boolean isValidCommand(String name) {
		GameCommands command = GameCommands.valueOf(name);
		if (command == null)
			return false;
		return true;
	}

	public static boolean isMovementCommand(String name) {
		GameCommands command = GameCommands.valueOf(name);
		if (command == null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.commandName;
	}
}
