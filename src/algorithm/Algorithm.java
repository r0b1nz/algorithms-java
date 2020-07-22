package algorithm;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.function.Supplier;

/**
 * An Algorithm container
 */
public interface Algorithm {

    /**
     * Name of the algorithm
     */
    default String getName() {
        return MethodHandles.lookup().lookupClass().getName();
    }

    /**
     * To test the algorithm
     */
    boolean test();

    /**
     * Runs and verifies tests
     */
    default boolean runAssertions(List<Supplier<Boolean>> tests) {
        return tests.stream().allMatch(Supplier::get);
    }
}
