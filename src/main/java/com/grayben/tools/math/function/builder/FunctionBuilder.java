package com.grayben.tools.math.function.builder;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Incrementally builds a composed function.
 * <p>
 * Builds a composed function by chaining any number of input adapters,
 * and/or any number of output adapters,
 * to the function specified during construction.
 * <p>
 * Created by Ben Gray on 3/02/2016.
 *
 * @param <X> the input type of the current effective function
 * @param <Y> the output type of the current effective function
 */
public class FunctionBuilder<X, Y> implements Supplier<Function<X, Y>> {

    /**
     * The composed function so far
     */
    final private Function<X, Y> functionSoFar;

    /**
     * Constructs a function builder starting with the specified function.
     * @param function the function upon which to build
     */
    public FunctionBuilder(final Function<X, Y> function) {

        if (function == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'function'");
        }

        this.functionSoFar = function;
    }

    /**
     * Compose the function so far with the specified input adapter.
     *
     * @param inputAdapter the input adapter with which to compose the function so far
     * @param <A> the type of input accepted by the specified input adapter, and hence, the new composed function
     * @return a new function builder holding the new composed function
     */
    public <A> FunctionBuilder<A, Y> prepend(final Function<? super A, ? extends X> inputAdapter){

        if (inputAdapter == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'inputAdapter'");
        }

        return new FunctionBuilder<>(functionSoFar.compose(inputAdapter));
    }

    /**
     * Compose the specified input adapter with the function so far.
     *
     * @param outputAdapter the output adapter with which to compose the function so far
     * @param <Z> the type of output produced by the specified output adapter, and hence, the new composed function
     * @return a new function builder holding the new composed function
     */
    public <Z> FunctionBuilder<X, Z> append(final Function<? super Y, ? extends Z> outputAdapter){

        if (outputAdapter == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'outputAdapter'");
        }

        return new FunctionBuilder<>(functionSoFar.andThen(outputAdapter));
    }

    /**
     * @return the input function composed with all adapters passed into this builder
     */
    public Function<X, Y> build(){
        return this.functionSoFar;
    }

    /**
     * @return the same output as {@link #build()}
     */
    @Override
    final public Function<X, Y> get() {
        return this.build();
    }
}
