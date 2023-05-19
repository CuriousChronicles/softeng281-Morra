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
    roundNum = 0;
    playerName = options[0];

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.player = new Player();
    isNewGame = true;

    // Create jarvis AI
    Strategy initialStrategy = new RandomStrategy();
    this.jarvis = jarvisFactory.createJarvis(difficulty);
    jarvis.setStrategy(initialStrategy);
  }

  public void play() {
    if (isNewGame == true) {
      roundNum++;
      jarvis.changeStrategy(roundNum, player.fingersDatabase);
      MessageCli.START_ROUND.printMessage(Integer.toString(roundNum));
      player.play(playerName);

      // Get Jarvis fingers and sum
      int jarvisFingers = jarvis.getJarvisFingers();
      int jarvisSum = jarvis.getJarvisSum();

      jarvis.printJarvis();
      printOutcome(jarvisFingers, jarvisSum);

      player.addFingersToDatabase(player.getCurrentFinger());
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
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
