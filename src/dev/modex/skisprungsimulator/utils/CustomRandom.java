package dev.modex.skisprungsimulator.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The {@link CustomRandom} class is a utility class to easily
 * retrieve random values in a given boundry for double and integer numbers.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class CustomRandom {

    /**
     * Returns a random integer in the given boundry
     *
     * @param min Minimum integer that should be returned
     * @param max Maximum integer that should be returned
     * @return Number between inclusively min and max
     */
    public int nextInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Returns a random integer between 0 and max
     *
     * @param max Maximum integer that should be returned
     * @return Integer between inclusively 0 and max
     */
    public int nextInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

    /**
     * Returns a random double in the given boundry
     *
     * @param min Minimum double that should be returned
     * @param max Maximum double that should be returned
     * @return Double between inclusively min and max
     */
    public double nextDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    /**
     * Returns a random double between 0 and max
     *
     * @param max Maximum double that should be returned
     * @return Double between inclusively 0 and max
     */
    public double nextDouble(double max) {
        return ThreadLocalRandom.current().nextDouble(0, max);
    }
}
