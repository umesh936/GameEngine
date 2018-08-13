package com.umesh.gameEngine.Game;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.umesh.gameEngine.character.BaseCharacter;
import com.umesh.gameEngine.character.PlayerCharacter;
import com.umesh.gameEngine.externalReader.ExternalReader;
import com.umesh.gameEngine.things.DisplayableItems;
import com.umesh.gameEngine.things.Item;
import com.umesh.gameEngine.things.Weapon;
import com.umesh.gameEngine.utils.GameConstants;

/**
 * Class is responsible for loading all the game configuration from external
 * reader (files or Database)
 * 
 * @author umesh
 *
 */
public class GameConfiguration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2137677693333086638L;

	private static List<Stage> availableStages = new LinkedList<>();
	private static String gameName = "";
	private static ExternalReader reader;
	private static Map<String, String> AvailableWeaponMap = new HashMap<>();
	private static Map<String, String> GamePropertyMap = new HashMap<>();
	private static List<String> loadOldGamesName = new ArrayList<>();

	private static void loadOldGames() {
		String path = GamePropertyMap.get("SAVE_PATH") + gameName + File.separator + "savedGames";

		File[] files = new File(path).listFiles();
		if (files == null)
			return;
		for (File file : files) {
			if (file.isFile()) {
				loadOldGamesName.add(file.getName().substring(0, file.getName().indexOf(".")));
			}
		}
		System.out.println(loadOldGamesName);
	}

	public static boolean loadConfiguration(ExternalReader reader1) {
		reader = reader1;
		Map<String, String> propertyMap = reader.getPropertyMapFromEntity(GameConstants.ActiveGameNameProperty);
		if (propertyMap == null)
			return false;
		gameName = propertyMap.get(GameConstants.ActiveGame);
		AvailableWeaponMap = reader.getPropertyMapFromEntity(GameConstants.WeaponProperty);
		GamePropertyMap = reader.getPropertyMapFromEntity("Game");
		loadOldGames();
		return loadGameStages();
	}

	private static boolean loadGameStages() {
		try {
			Map<String, String> stagePropertyMap = reader
					.getPropertyMapFromEntity(GameConstants.StageConfigureProperty);

			int total_stage = Integer.parseInt((String) stagePropertyMap.get(GameConstants.stageConstant.TOTAL_STAGE));

			for (int i = 1; i <= total_stage; i++) {
				Stage stage = new Stage();
				stage.setStageId(i - 1);
				String systemCharInStage = stagePropertyMap.get(GameConstants.stageConstant.STAGE_SYSTEM_CHAR + i);
				stage.setSystemCharcter(loadCharacterWithName(systemCharInStage, true));
				stage.setStageDescription(stagePropertyMap.get(GameConstants.stageConstant.STAGE_DESCRIPTION + i));
				loadItemsToStage(stage, stagePropertyMap.get(GameConstants.stageConstant.STAGE_ITEMS + i));
				availableStages.add(stage);
			}

			return true;
		} catch (Exception e) {
			// At every exception we can raise event
			e.printStackTrace();
			return false;
		}
	}

	public static void loadItemsToStage(Stage stage, String csvItemString) {
		List<String> availableItems = Arrays.asList(csvItemString.split("\\s*,\\s*"));
		for (String name : availableItems) {
			Item item = new DisplayableItems(name);
			stage.addItemToList(item);
		}
	}

	public static BaseCharacter loadCharacterWithName(String name, boolean isSystemPlayer) {
		Map<String, String> characterMap = reader.getPropertyMapFromEntity(GameConstants.PlayerCharacterProperty);
		Map<String, String> systemPlayerMap = reader.getPropertyMapFromEntity(GameConstants.SystemCharacterProperty);
		Map<String, String> propertMap = systemPlayerMap;
		if (!isSystemPlayer) {
			propertMap = characterMap;
		}
		List<String> availableCharacter = Arrays
				.asList(propertMap.get(GameConstants.characterConstant.CHARACTER_NAMES).split(","));
		
		if (!availableCharacter.contains(name))
			return null;
		BaseCharacter player = new PlayerCharacter(name);

		player.setCharacterMaxHealth(
				Integer.parseInt((String) propertMap.get(name + GameConstants.characterConstant.MAX_HEALTH)));
		player.setPowerBosterFactor(
				Integer.parseInt((String) propertMap.get(name + GameConstants.characterConstant.BOOST_FACTOR)));
		player.setDescription((String) propertMap.get(name + GameConstants.characterConstant.DESCRIPTION));
		/*
		 * Loading Weapon
		 */
		int total_weapon = Integer.parseInt((String) propertMap.get(name + GameConstants.characterConstant.WEAPON));
		for (int i = 1; i <= total_weapon; i++) {
			String weaponName = propertMap.get(name + GameConstants.characterConstant.WEAPON + "_" + i);
			Weapon weapon = new Weapon(weaponName);
			weapon.setAttackPower(
					Integer.parseInt(AvailableWeaponMap.get(weaponName + GameConstants.WEAPON_ATTACK_POWER)));
			weapon.setMaxAvailablePower(
					Integer.parseInt(AvailableWeaponMap.get(weaponName + GameConstants.WEAPON_MAX_POWER)));
			player.addWeaponToList(weapon);
		}
		return player;

	}

	public static List<Stage> getAvailableStages() {
		return availableStages;
	}

	public static String getGameName() {
		return gameName;
	}

	public static Stage getNextStage(Stage currentStage) {
		if (currentStage == null) {
			return availableStages.get(0);
		}
		return availableStages.get(currentStage.getStageId() + 1);
	}

	public static Map<String, String> getGamePropertyMap() {
		return GamePropertyMap;
	}

	public static void setGamePropertyMap(Map<String, String> gamePropertyMap) {
		GamePropertyMap = gamePropertyMap;
	}

	public static List<String> getLoadOldGamesName() {
		return loadOldGamesName;
	}

	public static void setLoadOldGamesName(List<String> loadOldGamesName) {
		GameConfiguration.loadOldGamesName = loadOldGamesName;
	}
}
