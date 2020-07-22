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
public class MergeSort implements Algorithm {
    private ArrayList<Integer> array = new ArrayList<>();

    public MergeSort() {
        Random randomNumbers = new Random();
        for (int i = 0; i < randomNumbers.nextInt(30); i++) {
            array.add(randomNumbers.nextInt(1000));
        }
    }

    @Override
    public boolean test() {
        List<Integer> sortedList = sort(0, array.size() - 1);
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
        tests.add(() -> testList.equals(sortedList));
        return runAssertions(tests);
    }

    /*
     * Things needed
     * 1. merge(array1, array2) -> returns merged array
     * 2. sort(array, start, end)
     *      if single, return single item
     *      firstArray = sort(array, start, start+end/2)
     *      secondArray = sort(array, start+end/2 + 1, end)
     *      return merge(first, second)
     */

    private List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf) {
        int firstHalfIndexCounter = 0;
        int secondHalfHalfIndexCounter = 0;
        int firstHalfSize = firstHalf.size();
        int secondHalfSize = secondHalf.size();
        int mergedListElementsCount = firstHalfSize + secondHalfSize;
        ArrayList<Integer> mergedList = new ArrayList<>(mergedListElementsCount);

        for (int i = 0; i < mergedListElementsCount; i++) {

            if (firstHalfIndexCounter == firstHalfSize) {
                mergedList.add(i, secondHalf.get(secondHalfHalfIndexCounter));
                secondHalfHalfIndexCounter++;
                continue;
            }

            if (secondHalfHalfIndexCounter == secondHalfSize) {
                mergedList.add(i, firstHalf.get(firstHalfIndexCounter));
                firstHalfIndexCounter++;
                continue;
            }

            int firstHalfValue = firstHalf.get(firstHalfIndexCounter);
            int secondHalfValue = secondHalf.get(secondHalfHalfIndexCounter);

            if (firstHalfValue < secondHalfValue) {
                mergedList.add(i, firstHalfValue);
                firstHalfIndexCounter++;
            } else {
                mergedList.add(i, secondHalfValue);
                secondHalfHalfIndexCounter++;
            }
        }
        return mergedList;
    }

    /**
     * Sorting algorithm
     */
    private List<Integer> sort(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return array.subList(startIndex, endIndex + 1);
        }
        int halfIndex = (startIndex + endIndex) / 2;
        List<Integer> firstHalf = sort(startIndex, halfIndex);
        List<Integer> secondHalf = sort(halfIndex + 1, endIndex);
        return merge(firstHalf, secondHalf);
    }
}
