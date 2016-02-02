package com.grayben.tools.math.function.parametric;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.function.Function;

public class AdaptedParametricEquation<T, U, X, Y> implements ParametricEquation<T, X, Y> {

    private final Function<T, U> inputAdapter;
    private final ParametricEquation<U, X, Y> parametricEquation;

    public AdaptedParametricEquation(Function<T, U> inputAdapter, ParametricEquation<U, X, Y> parametricEquation) {
        this.inputAdapter = inputAdapter;
        this.parametricEquation = parametricEquation;
    }

    @Override
    public ImmutablePair<X, Y> apply(T option) {
        return parametricEquation.compose(inputAdapter).apply(option);
    }
}