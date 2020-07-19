package misc;

import algorithm.Algorithm;
import algorithm.BasicUtilityProvider;

import java.util.List;

public class RotateArray implements Algorithm {
    private BasicUtilityProvider.Utilities utilities;

    public RotateArray() {
        utilities = BasicUtilityProvider.getUtilities();
    }

    private void rotate(List<Integer> array, int rotateByNumberOfElements) {
        int noOfTimesToPerformRotation = GCD.findGCD(array.size(), rotateByNumberOfElements);
        for (int i = 0; i < noOfTimesToPerformRotation; i++) {
            // from Index i, rotate till it reaches back to i
            // 1 2 3 4 5 6 7 8
            performRotation(i, rotateByNumberOfElements, array);
        }
    }

    private void performRotation(int startingIndex, int rotateByNumberOfElements, List<Integer> array) {
        int i = startingIndex;
        int j = (startingIndex - rotateByNumberOfElements) > 0
                ? (startingIndex - rotateByNumberOfElements)
                : array.size() + (startingIndex - rotateByNumberOfElements);
        while (j != startingIndex) {
            utilities.swapItem(array, i, j);

            // Todo: Finish this
            int temp = j;
            j = j - rotateByNumberOfElements;
            i = j;
        }
    }

    @Override
    public boolean test() {
        return false;
    }
}
