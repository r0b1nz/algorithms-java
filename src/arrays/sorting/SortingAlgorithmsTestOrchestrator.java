package arrays.sorting;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortingAlgorithmsTestOrchestrator {
    private Set<SortAlgorithm> algorithmSet = new HashSet<>();

    private SortingAlgorithmsTestOrchestrator() {
        algorithmSet.add(new QuickSort());
        algorithmSet.add(new MergeSort());
    }

    private void runTests() {
        algorithmSet.forEach(algorithm -> {
            var testResult = algorithm.test();
            System.out.println(algorithm.getClass() + (testResult ? " Passed" : " Failed"));
        });
    }

    public static void main(String[] args) {
        var orchestrator = new SortingAlgorithmsTestOrchestrator();
        orchestrator.runTests();
    }
}
