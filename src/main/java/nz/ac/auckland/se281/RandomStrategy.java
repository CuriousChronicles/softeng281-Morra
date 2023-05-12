package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{

    @Override
    public int getJarvisFingers() {
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int getJarvisSum() {
        return Utils.getRandomNumber(2 + getJarvisFingers(), 10);
    }
    
}
