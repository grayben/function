package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.input.InputRetrievable;
import com.grayben.testOracle.generator.output.ExpectedOutputRetrievable;

/**
 * Created by beng on 7/01/2016.
 */
public interface InputAndExpectedOutputRetrievable<I, O>
        extends InputRetrievable<I>, ExpectedOutputRetrievable<O> {
}