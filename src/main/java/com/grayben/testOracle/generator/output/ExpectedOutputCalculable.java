package com.grayben.testOracle.generator.output;

/**
 * Created by beng on 13/01/2016.
 */
public interface ExpectedOutputCalculable<S, O> {
    O calculateExpectedOutput(S seed);
}
