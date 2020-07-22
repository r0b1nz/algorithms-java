package misc;

import algorithm.Algorithm;
import algorithm.BasicUtilityProvider;

import java.util.ArrayList;
import java.util.List;

public class RotateArray implements Algorithm {
    private BasicUtilityProvider.Utilities utilities;

    public RotateArray() {
        utilities = BasicUtilityProvider.getUtilities();
    }

    private List<Integer> rotate(List<Integer> arrays, int rotateByNumberOfElements) {
        List<Integer> array = new ArrayList<>(arrays);
        rotateByNumberOfElements = rotateByNumberOfElements % array.size();
        int noOfTimesToPerformRotation = GCD.findGCD(array.size(), rotateByNumberOfElements);
        for (int i = 0; i < noOfTimesToPerformRotation; i++) {
            // from Index i, rotate till it reaches back to i
            // 1 2 3 4 5 6 7 8
            performRotation(i, rotateByNumberOfElements, array);
        }
        return array;
    }

    private void performRotation(int startingIndex, int rotateByNumberOfElements, List<Integer> array) {
        int arraySize = array.size();
        int i = startingIndex;
        int j = getPreviousIndex(i, rotateByNumberOfElements, arraySize);
        while (j != startingIndex) {
            utilities.swapItem(array, i, j);
            int olderJ = j;
            j = getPreviousIndex(j, rotateByNumberOfElements, arraySize);
            i = olderJ;
        }
    }

    private int getPreviousIndex(int from, int steps, int arraySize) {
        if (from - steps < 0) {
            return (arraySize + from - steps);
        } else {
            return from - steps;
        }
    }

    @Override
    public boolean test() {
        List<Integer> testList = getRandomList();
        int timesToBeRotated = utilities.getRandomInt(1000);
        List<Integer> rotatedList1 = getRotatedListUsingInefficientMethod(testList, timesToBeRotated);
        List<Integer> rotatedList2 = rotate(testList, timesToBeRotated);
        for (int i = 0; i < testList.size(); i++) {
            if (!rotatedList1.get(i).equals(rotatedList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getRotatedListUsingInefficientMethod(List<Integer> list, int times) {
        int size = list.size();
        times = times % size;
        int j = times;
        List<Integer> rotatedArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            j = j % size;
            rotatedArray.add(list.get(j));
            j++;
        }
        return rotatedArray;
    }

    private List<Integer> getRandomList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < utilities.getRandomInt(100); i++) {
            list.add(i);
        }
        return list;
    }
}
