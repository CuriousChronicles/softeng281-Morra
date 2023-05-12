package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

    public Jarvis createJarvis(Difficulty difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                return new EasyJarvis();
            case MEDIUM:
                return new MediumJarvis();
            case HARD:
                return new HardJarvis();
            case MASTER:
                return new MasterJarvis();
        }
    }}
