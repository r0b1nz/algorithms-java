package sort;

import algorithm.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Class implementing the quick sort logic
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
public class QuickSort implements Algorithm {
    private ArrayList<Integer> array = new ArrayList<>();

    public QuickSort() {
        Random randomNumbers = new Random();
        for (int i = 0; i < randomNumbers.nextInt(30); i++) {
            array.add(randomNumbers.nextInt(1000));
        }
    }

    @Override
    public boolean test() {
        sort(0, array.size() - 1);
        ArrayList<Integer> testList = new ArrayList<>(array);
        testList.sort((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o2 > o1) {
                return -1;
            } else {
                return 0;
            }
        });

        List<Supplier<Boolean>> tests = new ArrayList<>();
        tests.add(() -> testList.equals(array));
        return runAssertions(tests);
    }

    /**
     * Sorting algorithm
     */
    private void sort(int startIndex, int endIndex) {
        /*
         * 1. Find pivot index + Put the pivot element at the right place
         * 2. Call the same function for left and right side of the partition
         */

        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = getAndPutPivotAtRightPlace(startIndex, endIndex);
        sort(startIndex, pivotIndex - 1);
        sort(pivotIndex + 1, endIndex);
    }

    /**
     * Pivot: Choosing the last element as the pivot
     *
     * @return the pivot element's index after correction
     */
    private int getAndPutPivotAtRightPlace(int startIndex, int endIndex) {
        int pivotIndex = 0;
        int pivotValue = array.get(endIndex);

        for (int i = 0; i < endIndex; i++) {
            if (array.get(i) <= pivotValue) {
                swap(i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(pivotIndex, endIndex);
        return pivotIndex;
    }

    /**
     * Swap the elements
     */
    private void swap(int index1, int index2) {
        int value = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, value);
    }
}
