package com.grayben.tools.function.orderedPair.output;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class CalculatingOutputSupplier<S, O> implements Supplier<O> {
    private final Supplier<S> seedSupplier;
    private final Function<S, O> seedToOutputFunction;

    private O output;

    public CalculatingOutputSupplier(){
        this.seedSupplier = seedSupplier();
        this.seedToOutputFunction = seedToOutputFunction();
    }

    protected abstract Supplier<S> seedSupplier();
    protected abstract Function<S, O> seedToOutputFunction();

    @Override
    public O get() {
        if (output == null) {
            this.output = this.seedToOutputFunction.apply(this.seedSupplier.get());
        }
        return this.output;
    }
}
