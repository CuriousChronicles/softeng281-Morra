package nz.ac.auckland.se281;

public class EasyJarvis {
  // Implements the random AI strategy

  public int getJarvisFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  public int getJarvisSum() {
    return Utils.getRandomNumber(2 + getJarvisFingers(), 10);
  }

  public void printJarvis() {
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", "%s", "%s");
  }
}
