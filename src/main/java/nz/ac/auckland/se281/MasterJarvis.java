package nz.ac.auckland.se281;

import java.util.List;

public class MasterJarvis extends Jarvis {

  @Override
  public void changeStrategy(int roundNum, List<Integer> playerFingers) {
    if ((roundNum >= 4)) {
      // Alternate through average and top strategy
      if (roundNum % 2 == 0) {
        setStrategy(new AverageStrategy());
      } else {
        setStrategy(new TopStrategy());
      }
      this.strategy.getPreviousPlayersFingers(playerFingers);
    }
  }
}
