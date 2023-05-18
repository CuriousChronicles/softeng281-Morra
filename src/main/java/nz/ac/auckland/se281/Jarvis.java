package nz.ac.auckland.se281;

import java.util.List;

public abstract class Jarvis {
  protected int jarvisFingers;
  protected int jarvisSum;
  private Strategy strategy;

  // ArrayList<Integer> previousPlayersFingers;

  // private int roundCount = 0;

  public abstract int getJarvisFingers();

  public abstract int getJarvisSum();

  // All Jarvis print out the same thing
  public void printJarvis() {
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(jarvisFingers), Integer.toString(jarvisSum));
  }

  // public void setStrategy(Strategy strategy) {
  //   this.strategy = strategy;
  // }

  // public abstract void changeStrategy(int roundNum);

  // public void setPreviousPlayersFingers(ArrayList<Integer> playersFingersList) {
  //   this.previousPlayersFingers = playersFingersList;
  // }

  public void changeStrategy(int roundNum, List<Integer> playersFingers) {}
}
