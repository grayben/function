package com.grayben.testOracle.generator.output;

import com.grayben.testOracle.AbstractBuilder;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedExpectedOutputGenerator<S, O> implements ExpectedOutputRetrievable<O>{

    private final S seed;
    private final Function<S, O> function;

    private O expectedOutput;

    protected SeedBasedExpectedOutputGenerator(Builder<S, O> builder){
        this.seed = builder.seed;
        this.function = builder.function;
    }

    public static class Builder<S, O> implements AbstractBuilder<SeedBasedExpectedOutputGenerator<S, O>>  {

        private final S seed;
        private final Function<S, O> function;

        public Builder(S seed, Function<S, O> function){
            this.seed = seed;
            this.function = function;
        }

        @Override
        public SeedBasedExpectedOutputGenerator<S, O> build() {
            SeedBasedExpectedOutputGenerator<S, O> structure = new SeedBasedExpectedOutputGenerator<>(this);
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

    public O getExpectedOutput() {
        if (expectedOutput == null) {
            assert this.seed != null;
            assert this.function != null;
            this.expectedOutput = this.function.apply(this.seed);
        }
        return this.expectedOutput;
    }
}
