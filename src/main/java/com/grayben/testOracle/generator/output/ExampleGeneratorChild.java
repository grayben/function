package com.grayben.testOracle.generator.output;

import java.util.function.Function;

/**
 * Created by beng on 14/01/2016.
 */
public class ExampleGeneratorChild extends SeedBasedExpectedOutputGenerator<Integer, String> {

    protected ExampleGeneratorChild(Builder<Integer, String> builder) {
        super(builder);
    }

    public static class Director extends Builder.Director<Integer, String> {

        public enum Option {
            DEFAULT
        }

        private Option option;

        public Director(Option option){
            this.option = option;
        }

        @Override
        protected Integer generateSeed() {
            Integer seed = null;
            switch (option){
                case DEFAULT:
                    seed = 1;
                    break;
            }
            return seed;
        }

        @Override
        protected Function<Integer, String> generateFunction() {
            Function<Integer, String> function = null;
            switch (option){
                case DEFAULT:
                    function = integer -> integer.toString();
                    break;
            }
            return function;
        }
    }
}
