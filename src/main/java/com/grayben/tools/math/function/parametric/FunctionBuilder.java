package com.grayben.tools.math.function.parametric;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Ben Gray on 3/02/2016.
 */
public class FunctionBuilder<X, Y> {

    Class<?> intermediateType;

    FunctionComponents<X, ?, Y> functionComponents;

    public <A> void inputAdapter(Class<A> intermediateType, Function<X, A> inputAdapter){
        this.intermediateType = intermediateType;
        if (functionComponents == null) {
            functionComponents = new FunctionComponents<>(intermediateType);
        }
        functionComponents = new FunctionComponents<>(intermediateType);
    }

    public <A, B> void adaptInput(Class<B> newIntermediateType, Function<A, B> inputAdapter){
        if (functionComponents.getClass().getTypeParameters().)
        this.functionComponents =
    }

    public Function<X, Y> build(){
        return functionComponents.build();
    }

    //TODO: use this construct in TestContainer
    private static class FunctionComponents<X, A, Y> implements Supplier<Function<X, Y>> {

        final private Class<A> intermediateType;

        private Function<X, A> inputAdapter;
        private Function<A, Y> function;

        private FunctionComponents(Class<A> intermediateType) {
            this.intermediateType = intermediateType;
        }

        public Function<X, Y> build() {
            if (inputAdapter == null || function == null) {
                throw new IllegalStateException("the inputAdapter and function have not both been set");
            }
            return inputAdapter.andThen(function);
        }

        public <B> FunctionComponents<X, B, Y> adaptInput(Function<A, B> inputAdapter){
            FunctionComponents<X, B, Y> functionComponents = new FunctionComponents<>(intermediateType);
            functionComponents.inputAdapter = this.inputAdapter.andThen(inputAdapter);
            functionComponents.function = null;
            return functionComponents;
        }

        public FunctionComponents<X, A, Y> function(Function<A, Y> function){
            this.function = function;
            return this;
        }

        @Override
        public Function<X, Y> get() {
            return this.build();
        }
    }

    public static void main(String[] args){
        FunctionBuilder<String, String> functionBuilder = new FunctionBuilder<>();
        functionBuilder.adaptInput(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

    }


}
