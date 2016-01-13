package com.grayben.testOracle.generator.input;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedInputGenerator<S, I> implements InputRetrievable<I> {

    private S seed;
    private I input;
    private Function<S, I> function;

    public SeedBasedInputGenerator(S seed, Function<S, I> function){
        processInitParams(seed, function);
    }

    private void processInitParams(S seed, Function<S, I> function) {
        validateInitParams(seed, function);
        this.seed = seed;
        this.function = function;
    }

    private void validateInitParams(S seed, Function<S, I> function) {
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

    public I getInput(){
        if (input == null) {
            assert this.seed != null;
            assert this.function != null;
            this.input = function.apply(this.seed);
        }
        return this.input;
    }
}
