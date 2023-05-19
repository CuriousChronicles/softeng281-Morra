package nz.ac.auckland.se281;

import java.util.List;

public abstract class Jarvis {
  protected int jarvisFingers;
  protected int jarvisSum;
  protected Strategy strategy;

  public int getJarvisFingers() {
    this.jarvisFingers = strategy.getJarvisFingers();
    return jarvisFingers;
  }

  public int getJarvisSum() {
    this.jarvisSum = strategy.getJarvisSum();
    return jarvisSum;
  }

  // All Jarvis print out the same thing
  public void printJarvis() {
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(jarvisFingers), Integer.toString(jarvisSum));
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract void changeStrategy(int roundNum, List<Integer> playersFingers);
}
