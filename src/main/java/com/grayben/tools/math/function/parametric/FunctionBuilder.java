package com.grayben.tools.math.function.parametric;

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
 * @param <U> the input type of the current effective function
 * @param <V> the output type of the current effective function
 */
public class FunctionBuilder<U, V> implements Supplier<Function<U, V>> {

    /**
     * The composed function so far
     */
    final private Function<U, V> functionSoFar;

    /**
     * Constructs a function builder starting with the specified function.
     * @param function the function upon which to build
     */
    public FunctionBuilder(final Function<U, V> function) {
        this.functionSoFar = function;
    }

    /**
     * Compose the function so far with the specified input adapter.
     *
     * @param inputAdapter the input adapter with which to compose the function so far
     * @param <A> the type of input accepted by the specified input adapter, and hence, the new composed function
     * @return a new function builder holding the new composed function
     */
    final public <A> FunctionBuilder<A, V> prepend(final Function<A, U> inputAdapter){
        return new FunctionBuilder<>(functionSoFar.compose(inputAdapter));
    }

    /**
     * Compose the specified input adapter with the function so far.
     *
     * @param outputAdapter the output adapter with which to compose the function so far
     * @param <Z> the type of output produced by the specified output adapter, and hence, the new composed function
     * @return a new function builder holding the new composed function
     */
    final public <Z> FunctionBuilder<U, Z> append(final Function<V, Z> outputAdapter){
        return new FunctionBuilder<>(outputAdapter.compose(functionSoFar));
    }

    /**
     * @return the input function composed with all adapters passed into this builder
     */
    final public Function<U, V> build(){
        return this.functionSoFar;
    }

    /**
     * @return the same output as {@link #build()}
     */
    @Override
    final public Function<U, V> get() {
        return this.build();
    }
}
