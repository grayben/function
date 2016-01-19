package com.grayben.tools.math.parametricEquation.parameter;

import java.util.function.Function;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class CalculatingFunctionFunctionParameterSupplier<I, S> implements FunctionParameterRetrievable<S> {

    private final I input;
    private final Function<I, S> function;

    private S calculatedSeed;

    protected CalculatingFunctionFunctionParameterSupplier() {
        this.input = supplyInput();
        this.function = supplySeedCalculator();
    }

    protected abstract I supplyInput();

    protected abstract Function<I,S> supplySeedCalculator();

    @Override
    final public S getSeed() {
        if (calculatedSeed == null) {
            this.calculatedSeed = this.function.apply(input);
        }
        return this.calculatedSeed;
    }
}
