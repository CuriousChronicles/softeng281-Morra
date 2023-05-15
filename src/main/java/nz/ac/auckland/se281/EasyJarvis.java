package nz.ac.auckland.se281;

public class EasyJarvis extends Jarvis {
  // Uses random strategy
  Strategy randomStrategy = new RandomStrategy();

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = randomStrategy.getJarvisFingers();
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    this.jarvisSum = randomStrategy.getJarvisSum();
    return jarvisSum;
  }
}