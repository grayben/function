package com.grayben.tools.math.tuple.pair;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

/**
 * Created by beng on 18/01/2016.
 */
public interface OrderedPairCalculable<P, I, O> extends Function<P, Pair<I, O>> {
}
