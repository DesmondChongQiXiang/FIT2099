package game.utilities;

import java.util.Random;
/**
 * A class that model a chance event outcome
 */
public class ProbabilityGenerator {
    private static Random rand = new Random();
    /**
     * return an boolean of the outcome based on a chance event
     *
     * @param percentage the probability of an event
     */
    public static boolean generateProbability(int percentage){
        return rand.nextInt(100) <= percentage;
    }

}
