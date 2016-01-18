package com.grayben.tools.function.orderedPair;

import com.grayben.tools.function.orderedPair.input.InputRetrievable;
import com.grayben.tools.function.orderedPair.output.OutputRetrievable;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by beng on 18/01/2016.
 */
public class OrderedPair<I, O> extends AbstractMap.SimpleImmutableEntry<I, O>
        implements
        InputRetrievable<I>,
        OutputRetrievable<O> {

    public OrderedPair(I input, O output) {
        super(input, output);
    }

    public OrderedPair(Map.Entry<? extends I, ? extends O> entry) {
        super(entry);
    }

    @Override
    public I getInput() {
        return getKey();
    }

    @Override
    public O getOutput() {
        return getValue();
    }
}
