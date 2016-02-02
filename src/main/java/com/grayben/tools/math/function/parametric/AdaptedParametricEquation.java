package com.grayben.tools.math.function.parametric;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.function.Function;

/**
 * A parametric equation which first adapts the input given before
 * applying the underlying parametric equation to the adapted input.
 * <p>
 * This pattern can be chained by assigning another {@link AdaptedParametricEquation}
 * to {@link #parametricEquation}.
 * <p>
 * Created by Ben Gray on 20/1/2016
 * @param <T> the independent variable (parameter) type before adaptation
 * @param <U> the independent variable (parameter) type after adaptation
 * @param <X> the first dependent variable
 * @param <Y> the second dependent variable
 */
public class AdaptedParametricEquation<T, U, X, Y> implements ParametricEquation<T, X, Y> {

    /**
     * The function which converts input of type <T>
     */
    private final Function<T, U> inputAdapter;

    /**
     * The parametric equation which accepts the adapted input given by {@link #inputAdapter}
     */
    private final ParametricEquation<U, X, Y> parametricEquation;

    /**
     * Constructs an adapted parametric equation using the specified
     * input adapter and the specified underlying parametric equation.
     * @param inputAdapter the input adapter
     * @param parametricEquation the underlying parametric equation
     */
    public AdaptedParametricEquation(Function<T, U> inputAdapter, ParametricEquation<U, X, Y> parametricEquation) {
        this.inputAdapter = inputAdapter;
        this.parametricEquation = parametricEquation;
    }

    @Override
    public ImmutablePair<X, Y> apply(T option) {
        return parametricEquation.compose(inputAdapter).apply(option);
    }
}
