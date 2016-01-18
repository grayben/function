package com.grayben.tools.function;

import com.grayben.tools.InputAndExpectedOutputRetrievable;
import com.grayben.tools.sut.configuration.SUTConfigurationRetrievable;

/**
 * Created by beng on 8/01/2016.
 */
public abstract class FunctionOrderedPair<C, I, O>
        implements
        SUTConfigurationRetrievable<C>,
        InputAndExpectedOutputRetrievable<I, O>
{

    private final InputAndExpectedOutputRetrievable<I, O> inputAndExpectedOutputRetrievable;
    private final SUTConfigurationRetrievable<C> sutConfigurationRetrievable;

    public FunctionOrderedPair() {
        this.inputAndExpectedOutputRetrievable = generateInputAndExpectedOutputRetrievable();
        this.sutConfigurationRetrievable = generateSutConfigurationRetrievable();
        validateState();
    }

    protected abstract InputAndExpectedOutputRetrievable<I, O> generateInputAndExpectedOutputRetrievable();

    protected abstract SUTConfigurationRetrievable<C> generateSutConfigurationRetrievable();

    private void validateState() {
        if (this.inputAndExpectedOutputRetrievable == null) {
            throw new IllegalStateException(
                    "inputAndExpectedOutputRetrievable was null"
            );
        }
        if (this.sutConfigurationRetrievable == null) {
            throw new IllegalStateException(
                    "sutConfigurationRetrievable was null"
            );
        }
    }

    @Override
    final public I getInput() {
        assert inputAndExpectedOutputRetrievable != null;
        return inputAndExpectedOutputRetrievable.getInput();
    }

    @Override
    final public O getExpectedOutput() {
        assert inputAndExpectedOutputRetrievable != null;
        return inputAndExpectedOutputRetrievable.getExpectedOutput();
    }

    @Override
    public C getConfig() {
        assert sutConfigurationRetrievable != null;
        return sutConfigurationRetrievable.getConfig();
    }
}
