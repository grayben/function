package com.grayben.testOracle.generator.input;

import java.util.function.Function;

/**
 * Created by beng on 14/01/2016.
 */
public class ExampleWithFactory {

    SeedBasedInputGenerator<Integer, String>

    public static class SeedBasedInputGeneratorFactory {

        public enum Option {
            DEFAULT
        }

        public ExampleWithFactory produce(Option option){
            ExampleWithFactory artifact;
            switch (option){
                case DEFAULT:
                    Integer seed = 1;
                    Function<Integer, String> function = integer -> integer.toString();
                    return new ExampleWithFactory(seed, function);
            }
            return null;
        }

    }
}
