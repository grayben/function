package com.grayben.tools.function.orderedPair.expectedOutput;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class CalculatingExpectedOutputSupplier<S, O> implements Supplier<O> {
    private final Supplier<S> seedSupplier;
    private final Function<S, O> seedToExpectedOutputFunction;

    private O expectedOutput;

    public CalculatingExpectedOutputSupplier(){
        this.seedSupplier = seedSupplier();
        this.seedToExpectedOutputFunction = seedToExpectedOutputFunction();
    }

    protected abstract Supplier<S> seedSupplier();
    protected abstract Function<S, O> seedToExpectedOutputFunction();

    @Override
    public O get() {
        if (expectedOutput == null) {
            this.expectedOutput = this.seedToExpectedOutputFunction.apply(this.seedSupplier.get());
        }
        return this.expectedOutput;
    }
}
