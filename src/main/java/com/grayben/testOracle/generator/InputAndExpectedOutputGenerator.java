package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.input.InputRetrievable;
import com.grayben.testOracle.generator.output.ExpectedOutputRetrievable;

/**
 * Created by beng on 7/01/2016.
 */
public class InputAndExpectedOutputGenerator<I, O>
        implements InputAndExpectedOutputRetrievable<I, O> {

    InputRetrievable<I> inputGenerator;
    ExpectedOutputRetrievable<O> expectedOutputGenerator;

    protected InputAndExpectedOutputGenerator(
            InputRetrievable<I> inputGenerator,
            ExpectedOutputRetrievable<O> expectedOutputGenerator){
        processInitParams(inputGenerator, expectedOutputGenerator);

    }

    private void validateInitParams(
            InputRetrievable<I> inputGenerator,
            ExpectedOutputRetrievable<O> expectedOutputGenerator){
        if (inputGenerator == null) {
            throw new NullPointerException(
                    "inputGenerator was null"
            );
        }
        if (expectedOutputGenerator == null) {
            throw new NullPointerException(
                    "expectedOutputGenerator was null"
            );
        }
    }

    private void processInitParams(
            InputRetrievable<I> inputGenerator,
            ExpectedOutputRetrievable<O> expectedOutputGenerator){
        validateInitParams(inputGenerator, expectedOutputGenerator);
        this.inputGenerator = inputGenerator;
        this.expectedOutputGenerator = expectedOutputGenerator;
    }

    public I getInput() {
        return this.inputGenerator.getInput();
    }

    public O getExpectedOutput() {
        return this.expectedOutputGenerator.getExpectedOutput();
    }
}
