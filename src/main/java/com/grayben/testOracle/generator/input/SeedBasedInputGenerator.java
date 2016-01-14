package com.grayben.testOracle.generator.input;

import com.grayben.testOracle.AbstractBuilder;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedInputGenerator<S, I> implements InputRetrievable<I> {

    private final S seed;
    private final Function<S, I> function;

    private I input;

    protected SeedBasedInputGenerator(Builder<S, I> builder){
        this.seed = builder.seed;
        this.function = builder.function;

    }

    public static class Builder<S, I>
            implements AbstractBuilder<SeedBasedInputGenerator<S, I>> {

        private final S seed;
        private final Function<S, I> function;

        private Builder(S seed, Function<S, I> function){
            this.seed = seed;
            this.function = function;
        }

        public SeedBasedInputGenerator<S, I> build(){
            SeedBasedInputGenerator <S, I> structure = new SeedBasedInputGenerator<>(this);
            structure.validateState();
            return structure;
        }
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
