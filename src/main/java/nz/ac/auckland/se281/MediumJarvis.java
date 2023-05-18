package nz.ac.auckland.se281;

import java.util.List;

public class MediumJarvis extends Jarvis {
  // Medium Jarvis uses random strategy
  // after the forth round, the strategy is changed to average strategy

  // ArrayList<Integer> previousPlayersFingers;

  Strategy strategy;

  public MediumJarvis(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = strategy.getJarvisFingers();
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    this.jarvisSum = strategy.getJarvisSum();
    return jarvisSum;
  }

  @Override
  public void changeStrategy(int roundNum, List<Integer> playerFingers) {
    if ((roundNum >= 4)) {
      this.strategy = new AverageStrategy();
      this.strategy.getPreviousPlayersFingers(playerFingers);
    }
  }
}
