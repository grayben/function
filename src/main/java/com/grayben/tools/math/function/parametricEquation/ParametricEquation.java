package com.grayben.tools.math.function.parametricEquation;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

/**
 * Created by beng on 19/01/2016.
 */
public interface ParametricEquation<P, X, Y> extends Function<P, Pair<X, Y>> {
}

