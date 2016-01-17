package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.output.ExpectedOutputRetrievable;
import com.grayben.testOracle.generator.input.InputRetrievable;

/**
 * Created by beng on 17/01/2016.
 */
public interface InputAndExpectedOutputRetrievable<I, O>
        extends InputRetrievable<I>,
        ExpectedOutputRetrievable<O> {
}
