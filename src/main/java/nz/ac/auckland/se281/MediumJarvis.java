package nz.ac.auckland.se281;

import java.util.List;

public class MediumJarvis extends Jarvis {

  @Override
  public void changeStrategy(int roundNum, List<Integer> playerFingers) {
    if ((roundNum >= 4)) {
      setStrategy(new AverageStrategy());
      this.strategy.getPreviousPlayersFingers(playerFingers);
    }
  }
}
