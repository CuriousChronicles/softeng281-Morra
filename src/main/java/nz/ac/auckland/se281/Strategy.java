package nz.ac.auckland.se281;

import java.util.List;

public interface Strategy {
  public int getJarvisFingers();

  public int getJarvisSum();

  public void getPreviousPlayersFingers(List<Integer> playersFingers);
}
