package nz.ac.auckland.se281;

public abstract class Jarvis {
  protected int jarvisFingers;
  protected int jarvisSum;

  public abstract int getJarvisFingers();

  public abstract int getJarvisSum();

  // All Jarvis print out the same thing
  public void printJarvis() {
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(jarvisFingers), Integer.toString(jarvisSum));
  }
}