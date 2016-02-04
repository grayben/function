package com.grayben.tools.math.function.parametric;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Ben Gray on 3/02/2016.
 */
public class FunctionBuilder<U, V> implements Supplier<Function<U, V>> {

    final private Function<U, V> function;

    private FunctionBuilder(Function<U, V> underlyingFunction) {
        this.function = underlyingFunction;
    }

    public Function<U, V> build() {
        return function;
    }

    public <A> FunctionBuilder<A, V> prependInputAdapter(Function<A, U> inputAdapter){
        return new FunctionBuilder<>(inputAdapter.andThen(function));
    }

    public <Z> FunctionBuilder<U, Z> appendOutputAdapter(Function<V, Z> outputAdapter){
        return new FunctionBuilder<>(function.andThen(outputAdapter));
    }

    @Override
    public Function<U, V> get() {
        return this.build();
    }
}
