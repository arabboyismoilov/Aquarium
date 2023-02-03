package uz.furor.util;

public interface RandomGenerator {
    // Random number generator in range between min and max numbers given in parameters
    static int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}
