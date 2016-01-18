package com.grayben.tools.function;

import java.util.function.Function;

/**
 * Created by beng on 17/01/2016.
 */
public abstract class FunctionOrderedPairCalculator<S, C, I, O> {

    private final Function<S, FunctionOrderedPair<C, I, O>> function;

    public FunctionOrderedPairCalculator(){
        this.function = generateFunction();
    }

    public final FunctionOrderedPair<C, I, O> calculateFunctionOrderedPair(S seed){
        return this.function.apply(seed);
    }

    abstract protected Function<S, FunctionOrderedPair<C, I, O>> generateFunction();
}
