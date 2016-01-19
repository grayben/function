package com.grayben.tools.math.tuple.pair.input;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class CalculatingInputSupplier<S, I> implements Supplier<I> {
    private final Function<S, I> seedToInputFunction;
    private final Supplier<S> seedSupplier;



    private I input;

    public CalculatingInputSupplier() {
        this.seedToInputFunction = seedToInputFunction();
        this.seedSupplier = seedSupplier();
    }

    protected abstract Function<S, I> seedToInputFunction();

    protected abstract Supplier<S> seedSupplier();

    @Override
    public I get() {
        if (this.input == null) {
            this.input = this.seedToInputFunction.apply(this.seedSupplier.get());
        }
        return this.input;
    }
}
