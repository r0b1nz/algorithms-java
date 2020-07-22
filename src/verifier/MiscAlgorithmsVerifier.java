package verifier;

import misc.BinarySearch;
import misc.GCD;
import misc.RotateArray;

/**
 * Miscellaneous algorithms verifier
 *
 * @author Robin Gautam (robin.gautam341@gmail.com)
 */
public class MiscAlgorithmsVerifier extends AlgorithmVerifierBase implements AlgorithmVerifier {
    @Override
    String getName() {
        return "Misc Algorithms Verifier";
    }

    public MiscAlgorithmsVerifier() {
        // Nothing in here
    }

    @Override
    void registerAlgorithms() {
        getAlgorithms().add(new GCD());
        getAlgorithms().add(new RotateArray());
        getAlgorithms().add(new BinarySearch());
    }
}
