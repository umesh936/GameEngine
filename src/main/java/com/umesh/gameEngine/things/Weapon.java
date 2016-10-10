package com.umesh.gameEngine.things;

import java.io.Serializable;

public class Weapon implements Item, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1733302100732239563L;

	private String name;
	private Integer attackPower;
	private Integer maxAvailablePower;
	private Integer letfPower;
	private Boolean isAvailable = false;
	private String description;

	public Weapon(String name) {
		this.name = name;
	}

	public Weapon(String name, Integer attackPower, Integer maxAvailblePower, String description) {
		this.name = name;
		this.attackPower = attackPower;
		this.letfPower = attackPower;
		this.isAvailable = true;
		this.maxAvailablePower = maxAvailblePower;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(Integer attackPower) {
		this.attackPower = attackPower;
	}

	public Integer getMaxAvailablePower() {
		return maxAvailablePower;
	}

	public void setMaxAvailablePower(Integer maxAvailablePower) {
		this.maxAvailablePower = maxAvailablePower;
	}

	public Integer getLetfPower() {
		return letfPower;
	}

	public void setLetfPower(Integer letfPower) {
		this.letfPower = letfPower;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Boolean canPlayerGetThis() {
		return true;
	}

	@Override
	public Boolean isWeapon() {
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", attackPower=" + attackPower + ", description=" + description + "]";
	}

}
