package com.grayben.tools.math.function.parametric;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.function.Function;

/**
 * Defines a {@link Function} which returns two values represented as an {@link ImmutablePair}.
 * <p>
 * Created by Ben Gray on 19/01/2016.
 * @param <T> the independent variable type
 * @param <X> the first dependent variable type
 * @param <Y> the second dependent variable type
 */
public interface ParametricEquation<T, X, Y> extends Function<T, ImmutablePair<X, Y>> {
}

