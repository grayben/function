package com.grayben.tools.math.function;

import java.util.function.Function;

/**
 * A simple function which ignores input and always returns a specified output when {@link #apply(Object)} is invoked.
 * <p>
 * Created by Ben Gray on 1/02/2016.
 * @param <X> the input type
 * @param <Y> the output type
 */
public class ConstantFunction<X, Y> implements Function<X, Y> {

    /**
     * The constant to return when {@link #apply(Object)} is invoked.
     */
    private final Y constant;

    /**
     * Constructs a function which always returns {@link #constant} when {@link #apply(Object)} is invoked.
     * @param constant the value to return
     */
    public ConstantFunction(Y constant) {
        this.constant = constant;
    }

    /**
     * @param x input (which is ignored)
     * @return {@link #constant}
     */
    @Override
    public Y apply(X x) {
        // "ignore input";

        //return specified constant
        return this.constant;
    }
}
