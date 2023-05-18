package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  public Jarvis createJarvis(Difficulty difficulty, Strategy strategy) {
    switch (difficulty) {
      case EASY:
        return new EasyJarvis(strategy);
      case MEDIUM:
        return new MediumJarvis(strategy);
      case HARD:
        return new HardJarvis(strategy);
        // case MASTER:
        //     return new MasterJarvis();
      default:
        System.err.println("wrong Jarvis type");
        System.exit(0);
    }
    return null;
  }
}
