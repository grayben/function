package com.grayben.testOracle.generator;

/**
 * Created by beng on 7/01/2016.
 */
public abstract class SeedBasedInputExpectedOutputGenerator<S, I, O>
        implements InputAndExpectedOutputRetrievable<I, O> {

    I input;
    O expectedOutput;

    protected SeedBasedInputExpectedOutputGenerator(S seed){
        validateInitParams(seed);
        this.input = generateInput(seed);
        this.expectedOutput = generateExpectedOutput(seed);
    }

    protected abstract I generateInput(S seed);

    protected abstract O generateExpectedOutput(S seed);

    protected abstract void validateInitParams(S seed);

    public I getInput() {
        return this.input;
    }

    public O getExpectedOutput() {
        return this.expectedOutput;
    }
}
