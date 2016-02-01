package com.grayben.tools.math.function.parametricEquation;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

public class AdaptedParametricEquation<T, U, X, Y> implements ParametricEquation<T, X, Y> {

    private final Function<T, U> inputAdapter;
    private final ParametricEquation<U, X, Y> parametricEquation;

    public AdaptedParametricEquation(Function<T, U> inputAdapter, ParametricEquation<U, X, Y> parametricEquation) {
        this.inputAdapter = inputAdapter;
        this.parametricEquation = parametricEquation;
    }

    @Override
    public Pair<X, Y> apply(T option) {
        return parametricEquation.compose(inputAdapter).apply(option);
    }
}
