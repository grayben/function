package com.grayben.testOracle.generator.input;

import com.sun.istack.internal.NotNull;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public class SeedBasedInputGenerator<S, I> implements InputRetrievable<I> {

    private S seed;
    private I input;
    private Function<S, I> function;

    public SeedBasedInputGenerator(@NotNull S seed, @NotNull Function<S, I> function){
        this.seed = seed;
        this.function = function;
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
