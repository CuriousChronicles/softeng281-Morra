package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Player {
  // Need an arraylist to store players privious fingers
  private List<Integer> fingersDatabase = new ArrayList<>();
  private int currentPlayerFinger;
  private int currentPlayerSum;
  private String playerName;

  // Play method should get the players fingers and sum guess
  public void play(String playerName) {
    this.playerName = playerName;
    boolean isValidInput = false;

    while (isValidInput == false) {
      // Get players inputs
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      String[] playerInput = input.split(" ");
      this.playerName = playerName;

      // Check if players inputs are valid or not
      if (isValidInput(playerInput)) {
        int playerFingers = Integer.parseInt(playerInput[0]);
        int playerSum = Integer.parseInt(playerInput[1]);
        this.currentPlayerFinger = playerFingers;
        this.currentPlayerSum = playerSum;
        isValidInput = true;

        MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput[0], playerInput[1]);
      }
    }
  }

  public void addFingersToDatabase(int playerFingers) {
    fingersDatabase.add(playerFingers);
  }

  public boolean isValidInput(String[] playerInput) {
    boolean isValidInput = false;
    // Check if the string inputs can be converted into an integer
    if (playerInput.length == 2) {
      if (Utils.isInteger(playerInput[0]) && Utils.isInteger(playerInput[1])) {
        int playerFingers = Integer.parseInt(playerInput[0]);
        int playerSum = Integer.parseInt(playerInput[1]);

        // The the fingers and sum are within the correct range, then set isValidInput to true
        if ((playerFingers >= 1) && (playerFingers <= 5) && (playerSum >= 1) && (playerSum <= 10)) {
          isValidInput = true;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } else {
      MessageCli.INVALID_INPUT.printMessage();
    }
    return isValidInput;
  }

  public int getCurrentFinger() {
    return currentPlayerFinger;
  }

  public int getCurrentSum() {
    return currentPlayerSum;
  }

  public String getPlayerName() {
    return playerName;
  }

  public List<Integer> getFingersDatabase() {
    return fingersDatabase;
  }
}
