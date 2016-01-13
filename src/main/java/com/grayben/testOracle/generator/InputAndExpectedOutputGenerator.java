package com.grayben.testOracle.generator;

import com.grayben.testOracle.generator.input.InputRetrievable;
import com.grayben.testOracle.generator.output.ExpectedOutputRetrievable;
import com.sun.istack.internal.NotNull;

/**
 * Created by beng on 7/01/2016.
 */
public class InputAndExpectedOutputGenerator<I, O>
        implements InputAndExpectedOutputRetrievable<I, O> {

    InputRetrievable<I> inputGenerator;
    ExpectedOutputRetrievable<O> expectedOutputGenerator;

    protected InputAndExpectedOutputGenerator(
            @NotNull InputRetrievable<I> inputGenerator,
            @NotNull ExpectedOutputRetrievable<O> expectedOutputGenerator){
        validateInitParams(inputGenerator, expectedOutputGenerator);

    }

    private void validateInitParams(
            @NotNull InputRetrievable<I> inputGenerator,
            @NotNull ExpectedOutputRetrievable<O> expectedOutputGenerator){
        assert inputGenerator != null;
        assert expectedOutputGenerator != null;
    }

    private void processInitParams(
            @NotNull InputRetrievable<I> inputGenerator,
            @NotNull ExpectedOutputRetrievable<O> expectedOutputGenerator){
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
