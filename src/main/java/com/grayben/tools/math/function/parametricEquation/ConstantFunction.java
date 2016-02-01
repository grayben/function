package com.grayben.tools.math.function.parametricEquation;

import java.util.function.Function;

/**
 * Created by Ben Gray on 1/02/2016.
 */
public class ConstantFunction<X, Y> implements Function<X, Y> {

    private final Y constant;

    public ConstantFunction(Y constant) {
        this.constant = constant;
    }

    @Override
    public Y apply(X x) {
        // "ignore input";

        //return specified constant
        return this.constant;
    }
}
