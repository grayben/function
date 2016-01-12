package com.grayben.testOracle.generator;

/**
 * Created by beng on 7/01/2016.
 */
public interface InputAndExpectedOutputRetrievable<I, O> {

    I getInput();

    O getExpectedOutput();
}