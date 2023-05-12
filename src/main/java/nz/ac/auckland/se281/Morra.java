package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private Boolean isNewGame = false;
  private int roundNum = 0;
  private String playerName = null;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    isNewGame = true;

    // Create jarvis AI
    //Jarvis jarvis = AIFactory.createJarvis(difficulty);
  }

  public void play() {
    if (isNewGame == true) {
      roundNum++;
      MessageCli.START_ROUND.printMessage(Integer.toString(roundNum));

      Boolean validInput = false;

      // Check if inputs are correct
      while (validInput == false) {

        System.out.println("Give <fingers> <sum> and press enter");
        String input = Utils.scanner.nextLine();
        String[] humanInput = input.split(" ");

        if (Utils.isInteger(humanInput[0]) && Utils.isInteger(humanInput[1])) {
          int humanFingers = Integer.parseInt(humanInput[0]);
          int humanSum = Integer.parseInt(humanInput[1]);

          if ((humanFingers >= 1) && (humanFingers <= 5) && (humanSum >= 1) && (humanSum <= 10)) {
            validInput = true;
            MessageCli.PRINT_INFO_HAND.printMessage(playerName, humanInput[0], humanInput[1]);

          } else {
            MessageCli.INVALID_INPUT.printMessage();
          }
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void showStats() {}
}
