package com.grayben.testOracle.generator;

import com.grayben.testOracle.AbstractBuilder;
import com.grayben.testOracle.generator.input.InputRetrievable;
import com.grayben.testOracle.generator.output.ExpectedOutputRetrievable;

/**
 * Created by beng on 7/01/2016.
 */
public class InputAndExpectedOutputGenerator<I, O>
        implements InputAndExpectedOutputRetrievable<I, O> {

    private final InputRetrievable<I> inputRetrievable;
    private final ExpectedOutputRetrievable<O> expectedOutputRetrievable;

    private InputAndExpectedOutputGenerator(
            Builder builder){
        this.inputRetrievable = builder.inputRetrievable;
        this.expectedOutputRetrievable = builder.expectedOutputRetrievable;

    }

    public static class Builder<I, O> implements AbstractBuilder<InputAndExpectedOutputGenerator<I, O>>{

        private final InputRetrievable<I> inputRetrievable;
        private final ExpectedOutputRetrievable<O> expectedOutputRetrievable;

        public Builder(InputRetrievable<I> inputRetrievable, ExpectedOutputRetrievable<O> expectedOutputRetrievable){
            this.inputRetrievable = inputRetrievable;
            this.expectedOutputRetrievable = expectedOutputRetrievable;
        }

        @Override
        public InputAndExpectedOutputGenerator<I, O> build() {
            InputAndExpectedOutputGenerator<I, O> structure = new InputAndExpectedOutputGenerator<>(this);
            structure.validateState();
            return structure;
        }
    }

    private void validateState(){
        if (inputRetrievable == null) {
            throw new IllegalStateException(
                    "inputRetrievable was null"
            );
        }
        if (expectedOutputRetrievable == null) {
            throw new IllegalStateException(
                    "expectedOutputRetrievable was null"
            );
        }
    }

    public I getInput() {
        return this.inputRetrievable.getInput();
    }

    public O getExpectedOutput() {
        return this.expectedOutputRetrievable.getExpectedOutput();
    }
}
