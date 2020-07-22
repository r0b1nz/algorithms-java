package verifier;

import misc.BinarySearch;
import misc.GCD;
import misc.RotateArray;

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
