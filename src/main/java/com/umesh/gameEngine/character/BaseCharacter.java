package com.umesh.gameEngine.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.umesh.gameEngine.things.Weapon;

/**
 * These are the attributes of any character, there could be 2 type of character
 * player and system but we can more character who can have different power like
 * fly (SuperMan) or any marvel character etc.
 * 
 * @author umesh
 *
 */
public abstract class BaseCharacter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int characterMaxHealth;
	protected String name;
	protected String description;
	protected int currenthealth;
	protected int experience = 1;
	protected int powerBosterFactor;
	protected List<Weapon> loadedWeaponList = new ArrayList<>();
	protected Weapon selectedWeapon = null;;
	protected boolean isAlive = true;

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getCharacterMaxHealth() {
		return characterMaxHealth;
	}

	public void setCharacterMaxHealth(int characterMaxHealth) {
		this.characterMaxHealth = characterMaxHealth;
		this.currenthealth = characterMaxHealth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrenthealth() {
		return currenthealth;
	}

	public void setCurrenthealth(int currenthealth) {
		this.currenthealth = currenthealth;
	}

	public int getExperience() {
		return experience;
	}

	public void gainExperience() {
		Random RG = new Random();
		this.experience = experience + RG.nextInt(5) + 1;
	}

	public int getPowerBosterFactor() {
		return powerBosterFactor;
	}

	public void setPowerBosterFactor(int powerBosterFactor) {
		this.powerBosterFactor = powerBosterFactor;
	}

	public List<Weapon> getLoadedWeaponList() {
		return loadedWeaponList;
	}

	public void addWeaponToList(Weapon weapon) {
		if (selectedWeapon == null)
			selectedWeapon = weapon;
		this.loadedWeaponList.add(weapon);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void attack(BaseCharacter character) {
		System.out.println(
				"\n" + this.name + " is attacking " + character.name + " with Weapon " + selectedWeapon.getName());
		// System.out.println("Power boaster is " + name + " - "
		// +powerBosterFactor );
		character.makeDamage(this.selectedWeapon.getAttackPower() * this.powerBosterFactor);
		System.out.println(name + "'s Health is now " + currenthealth + " & " + character.getName() + "'s Health is "
				+ character.getCurrenthealth());
	}

	public void makeDamage(int power) {
		currenthealth = currenthealth - power;
		if (currenthealth <= 0)
			isAlive = false;
	}

	public String showWeaponList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--------------------------------------\n");
		for (Weapon weapon : loadedWeaponList) {
			buffer.append(weapon);
			buffer.append("\n");
		}
		buffer.append("\n-------------------------------------\n");
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("***********************************\n");
		buffer.append("                 Charcater Name : " + name);
		buffer.append("\n        Charcater DESCRIPTION : " + description);
		buffer.append("\n             Charcater Health : " + currenthealth);
		buffer.append("\n        Total Experience Gain : " + experience);
		buffer.append("\nCurrent Power boaster Factor  : " + powerBosterFactor);
		buffer.append("\n        Available Weapon List : \n");
		buffer.append(showWeaponList());
		buffer.append("***********************************\n");
		return buffer.toString();
	}

}
