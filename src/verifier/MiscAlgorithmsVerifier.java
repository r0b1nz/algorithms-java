package verifier;

import misc.GCD;

public class MiscAlgorithmsVerifier extends AlgorithmVerifierBase implements AlgorithmVerifier{
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
    }
}
