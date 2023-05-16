package nz.ac.auckland.se281;

public class EasyJarvis extends Jarvis {
  Strategy strategy;

  public EasyJarvis(Strategy strategy) {
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
}
