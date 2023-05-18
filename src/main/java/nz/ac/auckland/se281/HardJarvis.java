package nz.ac.auckland.se281;

import java.util.List;

public class HardJarvis extends Jarvis {
  private Strategy strategy;

  public HardJarvis(Strategy strategy) {
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
      this.strategy = new TopStrategy();
      this.strategy.getPreviousPlayersFingers(playerFingers);
    }
  }
}
