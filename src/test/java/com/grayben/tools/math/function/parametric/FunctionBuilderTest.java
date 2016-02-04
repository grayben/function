package com.grayben.tools.math.function.parametric;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Function;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.*;

/**
 * Created by Ben Gray on 4/02/2016.
 */
public class FunctionBuilderTest {

    public static final int NUM_RANDOM_INPUTS = 100 * 1000;

    private Function<Integer, String> start = Integer::toHexString;
    private Function<Double, Integer> prepend = Double::intValue;
    private Function<String, Integer> append = String::length;

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void
    test_initThrowsNullPointerException_whenFunctionIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new FunctionBuilder<>(null);
    }

    @Test public void
    test_prependThrowsNullPointerException_whenArgumentIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new FunctionBuilder<>(Integer::toHexString).prepend(null);
    }

    @Test public void
    test_appendThrowsNullPointerException_whenArgumentIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new FunctionBuilder<>(Integer::toHexString).append(null);
    }

    @Test public void
    test_composedFunctionOutputEqualsExpectedFunctionOutput_onRandomisedInputSuite() throws Exception {

        Function<Double, Integer> expected
                = start.compose(prepend).andThen(append);
        Function<Double, Integer> actual
                = new FunctionBuilder<>(start).prepend(prepend).append(append).build();

        for(int i = 0; i < NUM_RANDOM_INPUTS; i++){
            Double input = RandomUtils.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
            assertEquals(expected.apply(input), actual.apply(input));
        }

    }

    @Test public void
    test_getReturnsSameAsBuild() throws Exception {

        FunctionBuilder<Double, Integer> functionBuilder
                = new FunctionBuilder<>(start).append(append).prepend(prepend);

        assertSame(functionBuilder.build(), functionBuilder.get());
    }
}