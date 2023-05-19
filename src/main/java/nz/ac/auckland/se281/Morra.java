package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private Boolean isNewGame = false;
  private int roundNum = 0;
  private String playerName = null;
  private Player player;
  private int pointsToWin;
  private int jarvisPoints;
  private int playerPoints;

  // Create a static method, so then i don't need to create an instance of factory!
  private AIFactory jarvisFactory = new AIFactory();
  private Jarvis jarvis;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    isNewGame = true;
    roundNum = 0;
    jarvisPoints = 0;
    playerPoints = 0;
    this.pointsToWin = pointsToWin;
    playerName = options[0];

    // Print welcome player message
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.player = new Player();

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

      // Terminate game when points to reach has been met by either Jarvis or the player
      if (isGameEnds()) {
        String winner;
        if (jarvisPoints == pointsToWin) {
          winner = "Jarvis";
        } else {
          winner = player.getPlayerName();
        }
        MessageCli.END_GAME.printMessage(winner, Integer.toString(roundNum));
        isNewGame = false;
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  private boolean isGameEnds() {
    return ((jarvisPoints == pointsToWin) || (playerPoints == pointsToWin));
  }

  public void printOutcome(int jarvisFingers, int jarvisSum) {
    int actualSum = player.getCurrentFinger() + jarvisFingers;
    if ((actualSum == jarvisSum) && (actualSum == player.getCurrentSum())) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (actualSum == player.getCurrentSum()) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    } else if (actualSum == jarvisSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  public void showStats() {
    if (!isNewGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      // Print players stats
      int pointsNeededPlayer = pointsToWin - playerPoints;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          player.getPlayerName(),
          Integer.toString(playerPoints),
          Integer.toString(pointsNeededPlayer));

      // Print Jarvis stats
      int pointsNeededJarvis = pointsToWin - jarvisPoints;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(jarvisPoints), Integer.toString(pointsNeededJarvis));
    }
  }
}
