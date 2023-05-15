package nz.ac.auckland.se281;

public class MediumJarvis extends Jarvis {
  // Medium Jarvis uses random strategy
  // after the forth round, the strategy is changed to average strategy

  Strategy randomStrategy = new RandomStrategy();

  @Override
  public int getJarvisFingers() {
    return 0;
  }

  @Override
  public int getJarvisSum() {
    return 0;
  }
}
