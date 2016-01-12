package com.grayben.testOracle.oracle;

import com.grayben.testOracle.generator.InputAndExpectedOutputRetrievable;
import com.grayben.testOracle.generator.SystemUnderTestRetrievable;

/**
 * Created by beng on 8/01/2016.
 */
public abstract class SUTInputAndOutputOracle<SUT, I, O>
        implements
        SystemUnderTestRetrievable<SUT>,
        InputAndExpectedOutputRetrievable<I, O>
{

    private InputAndExpectedOutputRetrievable<I, O> ioGenerator;
    private SystemUnderTestRetrievable<SUT> sutGenerator;

    abstract protected void instantiateIoGenerator();
    abstract protected void instantiateSutGenerator();

    final public I getInput() {
        if (ioGenerator == null) {
            instantiateIoGenerator();
        }
        return ioGenerator.getInput();
    }

    final public O getExpectedOutput() {
        if (ioGenerator == null) {
            instantiateIoGenerator();
        }
        return ioGenerator.getExpectedOutput();
    }

    final public SUT getSUT() {
        if (sutGenerator == null) {
            instantiateSutGenerator();
        }
        return sutGenerator.getSUT();
    }
}
