package com.grayben.tools.function.orderedPair.output;

import java.util.function.Function;

/**
 * Created by beng on 13/01/2016.
 */
public abstract class SeedBasedOutputCalculator<S, O>
        implements OutputCalculable<S, O> {

    public final O calculateOutput(S seed) {
        return this.generateResult(seed);
    }

    @Override
    protected final Function<S, O> generateSeedToResultFunction() {
        return this.generateSeedToExpectedOutputFunction();
    }

    protected abstract Function <S, O> generateSeedToExpectedOutputFunction();
}
