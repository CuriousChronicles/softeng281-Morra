package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  private int jarvisFingers;

  @Override
  public int getJarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return jarvisFingers;
  }

  @Override
  public int getJarvisSum() {
    return Utils.getRandomNumber(1 + jarvisFingers, jarvisFingers + 5);
  }
}
