package com.grayben.tools;

import com.grayben.tools.function.orderedPair.expectedOutput.ExpectedOutputRetrievable;
import com.grayben.tools.function.orderedPair.input.InputRetrievable;

/**
 * Created by beng on 17/01/2016.
 */
public interface InputAndExpectedOutputRetrievable<I, O>
        extends InputRetrievable<I>, ExpectedOutputRetrievable<O> {}
