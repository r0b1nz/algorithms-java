package verifier;

import algorithm.Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Test Verifier Base Class
 */
public abstract class AlgorithmVerifierBase {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Setup algorithms
     */
    abstract void registerAlgorithms();

    /**
     * Name of the algorithm verifier
     */
    abstract String getName();

    /**
     * Set of all the algorithms to verify
     */
    private Set<Algorithm> algorithms = new HashSet<>();

    /**
     * Get the set of algorithms of the verifier
     */
    Set<Algorithm> getAlgorithms() {
        return algorithms;
    };

    /**
     * Perform all the tests
     */
    public void verify() {
        printHeader();
        registerAlgorithms();
        Set<Algorithm> passed = new HashSet<>();
        Set<Algorithm> failed = new HashSet<>();

        getAlgorithms().forEach(algorithm -> {
            if (algorithm.test()) {
                passed.add(algorithm);
            } else {
                failed.add(algorithm);
            }
        });

        printResults(passed, failed);
        printFooter();
    }

    private void printResults(Set<Algorithm> passed, Set<Algorithm> failed) {
        System.out.println("For " + getName());
        System.out.println("Success: " + passed.size() + "/" + (passed.size() + failed.size()));
        System.out.println(ANSI_GREEN + "Algorithms passed: " + passed + ANSI_RESET);
        System.out.println(ANSI_RED + "Algorithms Failed: " + failed + ANSI_RESET);
    }

    private void printHeader() {
        System.out.println("------- Running verification for [" + getName() + "] -------");
    }

    private void printFooter() {
        System.out.println("------- Finished verifying -------");
    }
}
