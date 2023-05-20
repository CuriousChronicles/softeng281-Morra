package nz.ac.auckland.se281;

import java.util.List;

public class EasyJarvis extends Jarvis {
  @Override
  public void changeStrategy(int roundNum, List<Integer> playersFingers) {
    setStrategy(new RandomStrategy());
  }
}
