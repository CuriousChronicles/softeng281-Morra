package nz.ac.auckland.se281;

public class EasyJarvis implements Jarvis {
  // Uses random strategy
  Strategy randomStrategy = new RandomStrategy();

  //   public void printJarvis() {
  //     int fingers = getJarvisFingers();
  //     int sum = getJarvisSum();
  //     MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(fingers),
  // Integer.toString(sum));
  //   }
}
