package algorithm;

import java.util.List;
import java.util.Random;

/**
 * Utilities provider
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
public final class BasicUtilityProvider {

    public static Utilities getUtilities() {
        return new Utilities();
    }

    public static class Utilities {
        private Random random;
        private Utilities() {
            random = new Random();
        }

        /**
         * Swap the elements
         */
        public void swapItem(List array, int index1, int index2) {
            Object value = array.get(index1);
            array.set(index1, array.get(index2));
            array.set(index2, value);
        }

        public int getRandomInt(int bound) {
            return random.nextInt(bound);
        }
    }
}
