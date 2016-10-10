package com.umesh.gameEngine.utils;

import java.io.File;

/**
 * Class responsible for holding all the constant used in the project.
 * 
 * @author umesh
 *
 */
public class GameConstants {

	public static final String BASE_PATH = "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator;

	/**
	 * Game constant
	 */
	public static final String ActiveGame = "ActiveGame";

	/**
	 * Properties File Name
	 */
	public static final String ActiveGameNameProperty = "Topic";
	public static final String RuleEngineProperty = "GameStateRule";
	public static final String WeaponProperty = "WeaponConfiguration";
	public static final String PlayerCharacterProperty = "AvailablePlayerCharacterInfo";
	public static final String SystemCharacterProperty = "AvailableSystemCharacterInfo";
	public static final String StageConfigureProperty = "StageConfigure";

	/**
	 * Message File Name
	 */
	public static final String IntroMessage = "IntroMessage";
	public static final String StartMessage = "GameStartMessage";
	public static final String OptionMessage = "OptionMessage";
	public static final String CompleteMessage = "CompleteGame";

	/**
	 * Weapon Related property Keys
	 */
	public static final String TOTAL_AVAILABLE_WEAPON = "weaponNames";
	public static final String WEAPON_ATTACK_POWER = "_ATTACK_POWER";
	public static final String WEAPON_MAX_POWER = "_MAX_POWER";

	/**
	 * Character related constant
	 */
	public interface characterConstant {
		public static final String CHARACTER_NAMES = "characterNames";
		public static final String ATTACK_POWER = "_ATTACK_POWER";
		public static final String MAX_HEALTH = "_MAX_HEALTH";
		public static final String DESCRIPTION = "_DESCRIPTION";
		public static final String SPECIAL_POWER = "_SPECIAL_POWER";
		public static final String WEAPON = "_WEAPON";
		public static final String BOOST_FACTOR="_BOOST_FACTOR";
		
	}

	/**
	 * Stage Related constant
	 * 
	 */
	public class stageConstant {
		public static final String TOTAL_STAGE = "TOTAL_STAGE";
		public static final String STAGE_SYSTEM_CHAR = "STAGE_SYSTEM_CHAR_";
		public static final String STAGE_DESCRIPTION="STAGE_DESCRIPTION_";
		public static final String STAGE_ITEMS="STAGE_ITEMS_";
	}

	/**
	 * Move Related constant
	 * 
	 */
	public class MoveConstant {
		public static final String RIGHT = "RIGHT";
		public static final String LEFT = "LEFT";
		public static final String FRONT = "FRONT";

		public static final String DISPLAY_RIGHT = "--";
		public static final String DISPLAY_LEFT = "--";
		public static final String DISPLAY_FRONT = "|";

	}
}
