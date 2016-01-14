package com.grayben.testOracle.oracle;

import com.grayben.testOracle.AbstractBuilder;
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

    private final InputAndExpectedOutputRetrievable<I, O> inputAndExpectedOutputRetrievable;
    private final SystemUnderTestRetrievable<SUT> systemUnderTestRetrievable;

    private SUTInputAndOutputOracle(Builder<SUT, I, O> builder) {
        this.inputAndExpectedOutputRetrievable = builder.inputAndExpectedOutputRetrievable;
        this.systemUnderTestRetrievable = builder.systemUnderTestRetrievable;
    }

    public static class Builder<SUT, I, O> implements AbstractBuilder<SUTInputAndOutputOracle<SUT, I, O>> {

        private final SystemUnderTestRetrievable<SUT> systemUnderTestRetrievable;
        private final InputAndExpectedOutputRetrievable<I, O> inputAndExpectedOutputRetrievable;

        public Builder(SystemUnderTestRetrievable<SUT> systemUnderTestRetrievable,
                       InputAndExpectedOutputRetrievable<I, O> inputAndExpectedOutputRetrievable){
            this.systemUnderTestRetrievable = systemUnderTestRetrievable;
            this.inputAndExpectedOutputRetrievable = inputAndExpectedOutputRetrievable;
        }

        @Override
        public SUTInputAndOutputOracle<SUT, I, O> build() {
            SUTInputAndOutputOracle<SUT, I, O> structure = new SUTInputAndOutputOracle<>(this);
            structure.validateState();
            return structure;
        }
    }

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
        return inputAndExpectedOutputRetrievable.getInput();
    }

    final public O getExpectedOutput() {
        assert inputAndExpectedOutputRetrievable != null;
        return inputAndExpectedOutputRetrievable.getExpectedOutput();
    }

    final public SUT getSUT() {
        assert systemUnderTestRetrievable != null;
        return systemUnderTestRetrievable.getSUT();
    }
}
