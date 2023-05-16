package nz.ac.auckland.se281;

public class EasyJarvis extends Jarvis {
  // Uses random strategy
  Strategy strategy = new RandomStrategy();

  // Strategy strategy;

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
  // public void setStrategy(Strategy strategy) {
  //   this.strategy = strategy;
  // }
}
