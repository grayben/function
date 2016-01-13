package com.grayben.testOracle.generator.output;

import com.sun.istack.internal.NotNull;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedExpectedOutputGenerator<S, O> implements ExpectedOutputRetrievable<O>{

    private S seed;
    private O expectedOutput;
    private Function<S, O> function;

    public SeedBasedExpectedOutputGenerator(@NotNull S seed, @NotNull Function<S, O> function){
        this.seed = seed;
        this.function = function;
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
