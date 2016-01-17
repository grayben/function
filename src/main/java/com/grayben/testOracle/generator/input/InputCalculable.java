package com.grayben.testOracle.generator.input;

/**
 * Created by beng on 13/01/2016.
 */
public interface InputCalculable<S, I> {
    I calculateInput(S seed);
}
