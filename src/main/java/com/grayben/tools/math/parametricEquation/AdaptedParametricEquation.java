package com.grayben.tools.math.parametricEquation;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

public class AdaptedParametricEquation<P, A, X, Y> implements ParametricEquation<P, X, Y> {

    private final Function<P, A> inputAdapter;
    private final ParametricEquation<A, X, Y> parametricEquation;

    public AdaptedParametricEquation(Function<P, A> inputAdapter, ParametricEquation<A, X, Y> parametricEquation) {
        this.inputAdapter = inputAdapter;
        this.parametricEquation = parametricEquation;
    }

    @Override
    public Pair<X, Y> apply(P option) {
        return parametricEquation.compose(inputAdapter).apply(option);
    }
}
