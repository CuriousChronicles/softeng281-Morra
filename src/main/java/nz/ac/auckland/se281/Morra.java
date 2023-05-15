package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private Boolean isNewGame = false;
  private int roundNum = 0;
  private String playerName = null;
  private Player player;

  // private AIFactory jarvisFactory = new AIFactory();
  // private Jarvis jarvis;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.player = new Player();
    isNewGame = true;

    // Create jarvis AI
    // this.jarvis = jarvisFactory.createJarvis(difficulty);
  }

  public void play() {
    if (isNewGame == true) {
      roundNum++;
      MessageCli.START_ROUND.printMessage(Integer.toString(roundNum));

      player.play(playerName);
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void showStats() {}
}
