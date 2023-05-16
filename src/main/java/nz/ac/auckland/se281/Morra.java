package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private Boolean isNewGame = false;
  private int roundNum = 0;
  private String playerName = null;
  private Player player;

  // Create a static method, so then i don't need to create an instance of factory!
  private AIFactory jarvisFactory = new AIFactory();
  private Jarvis jarvis;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.player = new Player();
    isNewGame = true;

    // Create jarvis AI
    this.jarvis = jarvisFactory.createJarvis(difficulty);
    // jarvis.setStrategy(Strategy );
  }

  public void play() {
    if (isNewGame == true) {
      roundNum++;
      MessageCli.START_ROUND.printMessage(Integer.toString(roundNum));
      player.play(playerName);

      // Get Jarvis fingers and sum
      int jarvisFingers = jarvis.getJarvisFingers();
      int jarvisSum = jarvis.getJarvisSum();

      jarvis.printJarvis();
      printOutcome(jarvisFingers, jarvisSum);

      // End the game
      // isNewGame = false;
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public int getRoundNum() {
    return roundNum;
  }

  public void printOutcome(int jarvisFingers, int jarvisSum) {
    int actualSum = player.getCurrentFinger() + jarvisFingers;
    if (actualSum == jarvisSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else if (actualSum == player.getCurrentSum()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void showStats() {}
}
