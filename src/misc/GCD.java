package misc;

import algorithm.Algorithm;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * Implement Greatest common divisor's algorithm
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
public class GCD implements Algorithm {
    private Map<Pair<Integer, Integer>, Integer> numberToGCDMap;

    public GCD() {
        numberToGCDMap = new HashMap<>();
        prepareDataset();
    }

    private void prepareDataset() {
        numberToGCDMap.put(new Pair<>(4, 12), 4);
        numberToGCDMap.put(new Pair<>(252, 105), 21);
        numberToGCDMap.put(new Pair<>(0, 10), 0);
        numberToGCDMap.put(new Pair<>(7, 13), 1);
    }

    @Override
    public boolean test() {
        List<Supplier<Boolean>> tests = new ArrayList<>();
        for (var numberAndGCD : numberToGCDMap.entrySet()) {
            int firstNumber = numberAndGCD.getKey().getKey();
            int secondNumber = numberAndGCD.getKey().getValue();
            int gcd = numberAndGCD.getValue();
            tests.add(() -> findGCD(firstNumber, secondNumber) == gcd);
        }
        return runAssertions(tests);
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        if (firstNumber == secondNumber) {
            return firstNumber;
        }
        if (min(firstNumber, secondNumber) == 0) {
            return 0;
        }
        if (min(firstNumber, secondNumber) == 1) {
            return 1;
        }
        return findGCD(abs(firstNumber - secondNumber), min(firstNumber, secondNumber));
    }


}
