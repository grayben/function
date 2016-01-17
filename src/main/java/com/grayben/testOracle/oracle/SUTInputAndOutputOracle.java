package com.grayben.testOracle.oracle;

import com.grayben.testOracle.generator.InputAndExpectedOutputCalculable;
import com.grayben.testOracle.generator.InputAndExpectedOutputRetrievable;
import com.grayben.testOracle.generator.sut.SystemUnderTestRetrievable;

/**
 * Created by beng on 8/01/2016.
 */
public abstract class SUTInputAndOutputOracle<SUT, I, O>
        implements
        SystemUnderTestRetrievable<SUT>,
        InputAndExpectedOutputRetrievable<I, O>
{

    private final InputAndExpectedOutputCalculable<?, I, O> inputAndExpectedOutputRetrievable;
    private final SystemUnderTestRetrievable<SUT> systemUnderTestRetrievable;

    public SUTInputAndOutputOracle() {
        this.inputAndExpectedOutputRetrievable = generateInputAndExpectedOutputRetrievable();
        this.systemUnderTestRetrievable = generateSutRetrievable();
        validateState();
    }

    protected abstract InputAndExpectedOutputCalculable<?, I, O> generateInputAndExpectedOutputRetrievable();

    protected abstract SystemUnderTestRetrievable<SUT> generateSutRetrievable();

    private void validateState() {
        if (this.inputAndExpectedOutputRetrievable == null) {
            throw new IllegalStateException(
                    "inputAndExpectedOutputRetrievable was null"
            );
        }
        if (this.systemUnderTestRetrievable == null) {
            throw new IllegalStateException(
                    "systemUnderTestRetrievable was null"
            );
        }
    }

    final public I getInput() {
        assert inputAndExpectedOutputRetrievable != null;
        return inputAndExpectedOutputRetrievable.calculateInput();
    }

    final public O getExpectedOutput() {
        assert inputAndExpectedOutputRetrievable != null;
        return inputAndExpectedOutputRetrievable.calculateExpectedOutput();
    }

    final public SUT getSUT() {
        assert systemUnderTestRetrievable != null;
        return systemUnderTestRetrievable.getSUT();
    }
}
