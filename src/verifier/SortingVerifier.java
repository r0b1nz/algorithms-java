package verifier;

import algorithm.Algorithm;
import sort.MergeSort;
import sort.QuickSort;

import java.util.HashSet;
import java.util.Set;

/**
 * Verifier of all the sorting algorithms
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
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
