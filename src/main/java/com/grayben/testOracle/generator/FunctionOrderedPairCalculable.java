package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.function.orderedPair.input.InputCalculable;
import com.grayben.testOracle.generator.function.orderedPair.expectedOutput.ExpectedOutputCalculable;

/**
 * Created by beng on 7/01/2016.
 */
public interface FunctionOrderedPairCalculable<S, I, O>
        extends InputCalculable<S, I>, ExpectedOutputCalculable<S, O> {
    // the input and expectedOutput must be related
}