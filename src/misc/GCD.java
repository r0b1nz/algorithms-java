package misc;

import algorithm.Algorithm;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.min;

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
        int failedCases = 0;
        for (var numberAndGCD : numberToGCDMap.entrySet()) {
            int firstNumber = numberAndGCD.getKey().getKey();
            int secondNumber = numberAndGCD.getKey().getValue();
            int gcd = numberAndGCD.getValue();
            if (findGCD(firstNumber, secondNumber) != gcd) {
                failedCases++;
            }
        }
        System.out.println("Successful cases: " + (numberToGCDMap.size() - failedCases) + "/" + numberToGCDMap.size());
        return failedCases == 0;
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
