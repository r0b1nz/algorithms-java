import verifier.AlgorithmVerifier;
import verifier.MiscAlgorithmsVerifier;
import verifier.SortingVerifier;

import java.util.HashSet;
import java.util.Set;

public class Application {
    private Set<AlgorithmVerifier> algorithmVerifiers;

    public Application() {
        registerVerifiers();
    }

    private void registerVerifiers() {
        Set<AlgorithmVerifier> verifiers = new HashSet<>();
        verifiers.add(new SortingVerifier());
        verifiers.add(new MiscAlgorithmsVerifier());
        this.algorithmVerifiers = verifiers;
    }

    public void runVerifier() {
        algorithmVerifiers.forEach(AlgorithmVerifier::verify);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.runVerifier();

    }
}
