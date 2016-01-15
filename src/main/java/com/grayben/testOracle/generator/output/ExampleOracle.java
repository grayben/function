package com.grayben.testOracle.generator.output;

/**
 * Created by beng on 14/01/2016.
 */
public class ExampleOracle {

    private final Option option;

    public enum Option {
        OPTION
    }

    ExpectedOutputRetrievable<String> expectedOutputRetrievable;

    public ExampleOracle(Option option){
        this.option = option;
        this.expectedOutputRetrievable
                = new ExampleGeneratorChild.Director(ExampleGeneratorChild.Director.Option.DEFAULT).getGenerator();
    }
}
