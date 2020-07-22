package misc;

import algorithm.Algorithm;
import algorithm.BasicUtilityProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Implement Binary Search algorithm
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
public class BinarySearch implements Algorithm {
    private BasicUtilityProvider.Utilities utilities;

    public BinarySearch() {
        utilities = BasicUtilityProvider.getUtilities();
    }

    @Override
    public String getName() {
        return "Binary Search";
    }

    private boolean hasElement(List<Integer> numbers, int searchKey) {
        return performBinarySearch(numbers, searchKey, 0, numbers.size() - 1);
    }

    private boolean performBinarySearch(List<Integer> numbers, int key, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return false;
        }

        // Check the middle element
        int middleIndex = (lowerBound + upperBound) / 2;
        if (numbers.get(middleIndex) == key) {
            return true;
        }

        // Figure out which sub-array we need to search in
        if (key < numbers.get(middleIndex)) {
            return performBinarySearch(numbers, key, lowerBound, middleIndex - 1);
        } else {
            return performBinarySearch(numbers, key, middleIndex + 1, upperBound);
        }
    }

    @Override
    public boolean test() {
        List<Integer> sortedEvenNumbers = new ArrayList<>();
        int counter = 0;
        while (counter < 1000) {
            sortedEvenNumbers.add(counter++ * 2);
        }

        List<Supplier<Boolean>> tests = new ArrayList<>();
        // Edge cases
        tests.add(() -> hasElement(sortedEvenNumbers, 0));
        tests.add(() -> hasElement(sortedEvenNumbers, 998));

        // Not found cases
        tests.add(() -> !hasElement(sortedEvenNumbers, -1));
        tests.add(() -> !hasElement(sortedEvenNumbers, 1023));

        // Must be found, random cases
        tests.add(() -> hasElement(sortedEvenNumbers, utilities.getRandomInt(400) * 2));
        tests.add(() -> hasElement(sortedEvenNumbers, utilities.getRandomInt(400) * 2));

        return runAssertions(tests);
    }
}
