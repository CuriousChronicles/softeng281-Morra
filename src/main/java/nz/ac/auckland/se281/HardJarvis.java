package nz.ac.auckland.se281;

import java.util.List;

public class HardJarvis extends Jarvis {

  @Override
  public void changeStrategy(int roundNum, List<Integer> playerFingers) {
    if ((roundNum >= 4)) {
      setStrategy(new TopStrategy());
      this.strategy.getPreviousPlayersFingers(playerFingers);
    }
  }
}
