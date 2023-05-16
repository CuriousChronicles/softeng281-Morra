package nz.ac.auckland.se281;

public class MediumJarvis extends Jarvis {
  // Medium Jarvis uses random strategy
  // after the forth round, the strategy is changed to average strategy

  // ArrayList of player fingers
  // ArrayList<Integer> previousPlayersFingers;

  Strategy strategy = new RandomStrategy();

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = strategy.getJarvisFingers();
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    return 0;
  }
}
