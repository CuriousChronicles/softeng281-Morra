package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Player {
  // Need an arraylist to store players privious fingers
  private List<Integer> fingersDatabase = new ArrayList<>();
  private int currentPlayerFinger;
  private int currentPlayerSum;
  private String playerName;

  public void play(String playerName) {
    boolean isValidInput = false;

    while (isValidInput == false) {
      System.out.println("Give <fingers> <sum> and press enter");
      String input = Utils.scanner.nextLine();
      String[] playerInput = input.split(" ");
      this.playerName = playerName;

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
    if (Utils.isInteger(playerInput[0]) && Utils.isInteger(playerInput[1])) {
      int playerFingers = Integer.parseInt(playerInput[0]);
      int playerSum = Integer.parseInt(playerInput[1]);

      if ((playerFingers >= 1) && (playerFingers <= 5) && (playerSum >= 1) && (playerSum <= 10)) {
        isValidInput = true;
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
