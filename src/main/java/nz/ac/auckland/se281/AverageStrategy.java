package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {
  private int jarvisFingers;
  List<Integer> previousPlayersFingers;

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    return (getAverage() + jarvisFingers);
  }

  @Override
  public void getPreviousPlayersFingers(List<Integer> playersFingersList) {
    this.previousPlayersFingers = playersFingersList;
  }

  public int getAverage() {
    float sum = 0f;
    for (Integer i : previousPlayersFingers) {
      sum += i;
    }

    return (int) Math.round(sum / previousPlayersFingers.size());
  }
}
