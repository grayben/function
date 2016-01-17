package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.input.InputCalculable;
import com.grayben.testOracle.generator.output.ExpectedOutputCalculable;

/**
 * Created by beng on 7/01/2016.
 */
public interface InputAndExpectedOutputCalculable<S, I, O>
        extends InputCalculable<S, I>, ExpectedOutputCalculable<S, O> {
    // the input and expectedOutput must be related
}