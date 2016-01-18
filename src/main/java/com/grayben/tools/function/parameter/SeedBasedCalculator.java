package com.grayben.tools.function.parameter;

import java.util.function.Function;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class SeedBasedCalculator<S, R> {
    private final Function<S, R> function;
    protected SeedBasedCalculator(){
        this.function = generateSeedToResultFunction();
        validateState();
    }

    protected abstract Function<S, R> generateSeedToResultFunction();

    private void validateState() {
        if (function == null) {
            throw new IllegalStateException(
                    "this.function is null"
            );
        }
    }

    public final R generateResult(S seed){
        return this.function.apply(seed);
    }
}
