package nz.ac.auckland.se281;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TopStrategy implements Strategy {
  private int jarvisFingers;
  private List<Integer> previousPlayersFingers;

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    int top = getTopValue();
    if (top == 0) {
      // If the top is 0, all values are the same so we pick any at random
      int topIndex = Utils.getRandomNumber(0, previousPlayersFingers.size() - 1);
      top = previousPlayersFingers.get(topIndex);
    }
    int sum = jarvisFingers + top;
    return sum;
  }

  @Override
  public void getPreviousPlayersFingers(List<Integer> playersFingers) {
    this.previousPlayersFingers = playersFingers;
  }

  public int getTopValue() {
    // Create a set of all unique human fingers
    Set<Integer> humanFingersSet = new LinkedHashSet<>();
    humanFingersSet.addAll(previousPlayersFingers);

    // Find the greatest count
    int greatestCount = 0;
    int numCount = 0;
    int topFinger = 0;
    for (Integer i : humanFingersSet) {
      for (Integer j : previousPlayersFingers) {
        if (i == j) {
          numCount++;
        }
      }
      if (numCount > greatestCount) {
        greatestCount = numCount;
        topFinger = i;
      }
      numCount = 0;
    }
    // If the topFinger is 0, this means that all the fingers have the same count
    return topFinger;
  }
}
