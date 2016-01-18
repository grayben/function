package com.grayben.tools.function.parameter;

import java.util.function.Function;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class CalculatingSeedSupplier<I, S> implements SeedRetrievable<S> {

    private final I input;
    private final Function<I, S> function;

    private S calculatedSeed;

    protected CalculatingSeedSupplier() {
        this.input = supplyInput();
        this.function = supplySeedCalculator();
    }

    protected abstract I supplyInput();

    protected abstract Function<I,S> supplySeedCalculator();

    @Override
    final public S getSeed() {
        if (calculatedSeed == null) {
            this.calculatedSeed = this.function.apply(input);
        }
        return this.calculatedSeed;
    }
}
