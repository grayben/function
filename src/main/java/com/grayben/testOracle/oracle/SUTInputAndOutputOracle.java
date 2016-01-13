package com.grayben.testOracle.oracle;

import com.grayben.testOracle.generator.InputAndExpectedOutputRetrievable;
import com.grayben.testOracle.generator.sut.SystemUnderTestRetrievable;

/**
 * Created by beng on 8/01/2016.
 */
public class SUTInputAndOutputOracle<SUT, I, O>
        implements
        SystemUnderTestRetrievable<SUT>,
        InputAndExpectedOutputRetrievable<I, O>
{

    private InputAndExpectedOutputRetrievable<I, O> ioGenerator;
    private SystemUnderTestRetrievable<SUT> sutGenerator;

    public SUTInputAndOutputOracle(
            InputAndExpectedOutputRetrievable<I, O> ioGenerator,
            SystemUnderTestRetrievable<SUT> sutGenerator
    ) {
        processInitParams(ioGenerator, sutGenerator);
        this.ioGenerator = ioGenerator;
        this.sutGenerator = sutGenerator;
    }

    private void processInitParams(
            InputAndExpectedOutputRetrievable<I, O> ioGenerator,
            SystemUnderTestRetrievable<SUT> sutGenerator) {
        validateInitParams(ioGenerator, sutGenerator);
        this.ioGenerator = ioGenerator;
        this.sutGenerator = sutGenerator;
    }

    private void validateInitParams(
            InputAndExpectedOutputRetrievable<I, O> ioGenerator,
            SystemUnderTestRetrievable<SUT> sutGenerator) {
        if (ioGenerator == null) {
            throw new NullPointerException(
                    "ioGenerator was null"
            );
        }
        if (sutGenerator == null) {
            throw new NullPointerException(
                    "sutGenerator was null"
            );
        }
    }

    final public I getInput() {
        assert ioGenerator != null;
        return ioGenerator.getInput();
    }

    final public O getExpectedOutput() {
        assert ioGenerator != null;
        return ioGenerator.getExpectedOutput();
    }

    final public SUT getSUT() {
        assert sutGenerator != null;
        return sutGenerator.getSUT();
    }
}
