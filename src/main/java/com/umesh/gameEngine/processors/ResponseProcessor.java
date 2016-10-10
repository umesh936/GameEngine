package com.umesh.gameEngine.processors;

public abstract class ResponseProcessor {

	public abstract void processAndRepondeToUser(String keyword);

	private void printCharacterRepeatedly(char c) {
		printCharacterRepeatedly(c, 50);
	}

	private void printCharacterRepeatedly(char c, int numberOfTimes) {
		System.out.println("\n");
		for (int i = 0; i < numberOfTimes; i++) {
			System.out.print(c);
		}
	}

	protected void printHeaderWithCharacter(char c) {
		printCharacterRepeatedly(c);
	}

	protected void printLongHeaderWithCharacter(char c) {
		printCharacterRepeatedly(c, 100);
	}

	protected void displayResponse(String response) {
			System.out.print("\n"+response);
			showPrompt();

	}

	protected void displayErrorMessage() {
		printHeaderWithCharacter('*');
		System.out.println("There is something Wrong happen with Game. Sorry will not be able to proceed.");
	}

	private void showPrompt() {
		System.out.print("\n>");
	}
}
