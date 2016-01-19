package com.grayben.tools.math.tuple.pair.output;

/**
 * Created by beng on 13/01/2016.
 */
public interface OutputCalculable<S, O> {
    O calculateOutput(S seed);
}
