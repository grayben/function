package com.grayben.testOracle.generator.output;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedExpectedOutputGenerator<S, O> implements ExpectedOutputRetrievable<O>{

    private S seed;
    private O expectedOutput;
    private Function<S, O> function;

    public SeedBasedExpectedOutputGenerator(S seed, Function<S, O> function){
        processInitParams(seed, function);
    }

    private void processInitParams(S seed, Function<S, O> function) {
        validateInitParams(seed, function);
        this.seed = seed;
        this.function = function;
    }

    private void validateInitParams(S seed, Function<S, O> function) {
        if (seed == null) {
            throw new NullPointerException(
                    "seed was null"
            );
        }
        if (function == null) {
            throw new NullPointerException(
                    "function was null"
            );
        }
    }

    public O getExpectedOutput() {
        if (expectedOutput == null) {
            assert this.seed != null;
            assert this.function != null;
            this.expectedOutput = this.function.apply(this.seed);
        }
        return this.expectedOutput;
    }
}
