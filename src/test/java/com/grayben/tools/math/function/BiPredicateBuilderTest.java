package com.grayben.tools.math.function;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by Ben Gray on 4/02/2016.
 */
public class BiPredicateBuilderTest {

    public static final int NUM_RANDOM_INPUTS = 1000 * 1000;

    public static final BiPredicate<Integer, Integer> START = (integer1, integer2) -> (integer1 - integer2) % 2 == 0;
    public static final Function<String, Integer> PREPEND1 = String::hashCode;
    public static final Function<Double, Integer> PREPEND2 = Object::hashCode;

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void
    test_initThrowsNullPointerException_whenBiPredicateIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new BiPredicateBuilder<>(null);
    }

    @Test public void
    test_prependToFirstInputThrowsNullPointerException_whenArgumentIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new BiPredicateBuilder<>(START).prependToFirstInput(null);
    }

    @Test public void
    test_prependToSecondInputThrowsNullPointerException_whenArgumentIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new BiPredicateBuilder<>(START).prependToSecondInput(null);
    }

    @Test public void
    test_composedBiPredicateOutputEqualsExpectedFunctionOutput_onRandomisedInputSuite() throws Exception {

        BiPredicate<String, Double> expected
                = (aString, aDouble) -> START.test(PREPEND1.apply(aString), PREPEND2.apply(aDouble));

        BiPredicate<String, Double> actual
                = new BiPredicateBuilder<>(START).prependToFirstInput(PREPEND1).prependToSecondInput(PREPEND2).build();

        for(int i = 0; i < NUM_RANDOM_INPUTS; i++){
            String stringInput = RandomStringUtils.random(255);
            Double doubleInput = RandomUtils.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
            assertEquals(expected.test(stringInput, doubleInput), actual.test(stringInput, doubleInput));
        }
    }

    @Test public void
    test_getReturnsSameAsBuild() throws Exception {

        BiPredicateBuilder<String, Double> biPredicateBuilder
                = new BiPredicateBuilder<>(START).prependToFirstInput(PREPEND1).prependToSecondInput(PREPEND2);

        assertSame(biPredicateBuilder.build(), biPredicateBuilder.get());
    }


}