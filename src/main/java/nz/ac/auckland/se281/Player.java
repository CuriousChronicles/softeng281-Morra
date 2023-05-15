package nz.ac.auckland.se281;

public class Player {
  // Need an arraylist to store players privious fingers

  public void play(String playerName) {
    boolean isValidInput = false;

    while (isValidInput == false) {
      System.out.println("Give <fingers> <sum> and press enter");
      String input = Utils.scanner.nextLine();
      String[] humanInput = input.split(" ");

      if (isValidInput(humanInput)) {
        isValidInput = true;
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, humanInput[0], humanInput[1]);
      }
    }
  }

  public boolean isValidInput(String[] playerInput) {
    boolean isValidInput = false;
    if (Utils.isInteger(playerInput[0]) && Utils.isInteger(playerInput[1])) {
      int humanFingers = Integer.parseInt(playerInput[0]);
      int humanSum = Integer.parseInt(playerInput[1]);

      if ((humanFingers >= 1) && (humanFingers <= 5) && (humanSum >= 1) && (humanSum <= 10)) {
        isValidInput = true;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
    return isValidInput;
  }
}
