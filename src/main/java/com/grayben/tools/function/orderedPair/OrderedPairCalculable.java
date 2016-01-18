package com.grayben.tools.function.orderedPair;

import java.util.function.Function;

/**
 * Created by beng on 18/01/2016.
 */
public interface OrderedPairCalculable<P, I, O> extends Function<P, OrderedPair<I, O>> {
}
