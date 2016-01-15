package com.grayben.testOracle.generator.input;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedInputGenerator<S, I> implements InputRetrievable<I> {

    private final S seed;
    private final Function<S, I> function;

    private I input;

    protected SeedBasedInputGenerator(S seed, Function<S, I> function){
        this.seed = seed;
        this.function = function;
    }

    public abstract class Factory implements Supplier<SeedBasedInputGenerator<S, I>> {
    }

    private void validateState() {
        if (seed == null) {
            throw new IllegalStateException(
                    "seed was null"
            );
        }
        if (function == null) {
            throw new IllegalStateException(
                    "function was null"
            );
        }
    }

    public I getInput(){
        if (input == null) {
            validateState();
            this.input = function.apply(this.seed);
        }
        return this.input;
    }
}
