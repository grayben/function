package com.grayben.testOracle.oracle;

import com.grayben.testOracle.generator.InputAndExpectedOutputRetrievable;
import com.grayben.testOracle.generator.SystemUnderTestRetrievable;
import com.sun.istack.internal.NotNull;

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
            @NotNull InputAndExpectedOutputRetrievable<I, O> ioGenerator,
            @NotNull SystemUnderTestRetrievable<SUT> sutGenerator
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
        assert ioGenerator != null;
        assert sutGenerator != null;
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
