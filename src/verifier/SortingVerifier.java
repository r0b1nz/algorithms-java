package verifier;

import algorithm.Algorithm;
import sort.MergeSort;
import sort.QuickSort;

import java.util.HashSet;
import java.util.Set;

public class SortingVerifier extends AlgorithmVerifierBase implements AlgorithmVerifier {
    @Override
    String getName() {
        return "Sorting Algorithms Verifier";
    }

    public SortingVerifier() {
        // Nothing in here
    }

    void registerAlgorithms()  {
        Set<Algorithm> algorithms = new HashSet<>();
        algorithms.add(new MergeSort());
        algorithms.add(new QuickSort());
        getAlgorithms().addAll(algorithms);
    }
}
