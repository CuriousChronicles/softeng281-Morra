package nz.ac.auckland.se281;

public abstract class Jarvis {
  protected int jarvisFingers;
  protected int jarvisSum;

  // private Strategy strategy;

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

  // public void changeStrategy(Morra game) {
  //   if (strategy instanceof RandomStrategy) {
  //     strategy = new RandomStrategy();
  //   } else if ((game.getRoundNum() == 3) && strategy instanceof AverageStrategy) {
  //     strategy = new AverageStrategy();
  //   }
  // }
}
