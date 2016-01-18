package com.grayben.tools.function.orderedPair.expectedOutput;

/**
 * Created by beng on 13/01/2016.
 */
public interface ExpectedOutputCalculable<S, O> {
    O calculateExpectedOutput(S seed);
}
