package com.grayben.tools.math.function;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Incrementally builds a composed supplier.
 * <p>
 * Builds a composed supplier by chaining any number of output adapters to the output
 * of the supplier specified during construction of an object of this class.
 * <p>
 * Created by Ben Gray on 4/02/2016.
 *
 * @param <X> the type of the output of the current effective {@link Supplier}
 */
public class SupplierBuilder<X> implements Supplier<Supplier<X>> {

    /**
     * The current effective {@link Supplier}
     */
    final private Supplier<X> supplierSoFar;

    /**
     * Constructs a builder based upon the specified {@link Supplier}.
     *
     * @param supplier the supplier upon which to form the composite supplier
     */
    public SupplierBuilder(Supplier<X> supplier) {
        this.supplierSoFar = supplier;
    }

    /**
     * Compose the specified output adapter with the current composed supplier.
     *
     * @param outputAdapter the output adapter with which to adapt the output of the current composed {@link Supplier}
     * @param <Y> the type of the output of the output produced by the specified output adapter,
     *           and hence, the type of the output of the new composed supplier
     * @return a new builder holding the new composed bi-predicate
     */
    final public <Y> SupplierBuilder<Y> append(Function<? super X, ? extends Y> outputAdapter){
        return new SupplierBuilder<>( () -> outputAdapter.apply(supplierSoFar.get()) );
    }

    /**
     * @return the composed supplier
     */
    final public Supplier<X> build() {
        return this.supplierSoFar;
    }

    /**
     * @return the same output as {@link #build()}
     */
    @Override
    final public Supplier<X> get() {
        return this.build();
    }
}
