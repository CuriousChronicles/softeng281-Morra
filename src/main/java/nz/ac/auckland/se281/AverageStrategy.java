package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {
  private int jarvisFingers;
  ArrayList<Integer> previousPlayersFingers;
  // Strategy strategy = new RandomStrategy();

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    return (getAverage() + jarvisFingers);
  }

  public void getPreviousPlayersFingers(ArrayList<Integer> playersFingersList) {
    this.previousPlayersFingers = playersFingersList;
  }

  public int getAverage() {
    int sum = 0;
    for (Integer i : previousPlayersFingers) {
      sum += i;
    }
    return Math.round(sum / previousPlayersFingers.size());
  }
}
