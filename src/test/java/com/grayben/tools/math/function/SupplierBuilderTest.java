package com.grayben.tools.math.function;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by Ben Gray on 4/02/2016.
 */
public class SupplierBuilderTest {

    public static final int NUM_RANDOM_INPUTS = 100 * 1000;

    public static final Function<Integer, String> ADAPTER = Integer::toHexString;

    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void
    test_initThrownNullPointerException_whenArgumentIsNull() throws Exception {

        thrown.expect(NullPointerException.class);

        new SupplierBuilder<>(null);
    }

    @Test public void
    test_appendThrowsNullPointerException_whenArgumentIsNull() throws Exception {
        thrown.expect(NullPointerException.class);

        new SupplierBuilder<>(() -> 42).append(null);
    }

    @Test public void
    test_composedSupplierOutputEqualsExpectedSupplierOutput_onRandomisedInitialSupplierSuite() throws Exception {

        for (int i = 0; i < NUM_RANDOM_INPUTS; i++){
            Supplier<Integer> start
                    = () -> (RandomUtils.nextInt(0, Integer.MAX_VALUE) - RandomUtils.nextInt(0, Integer.MAX_VALUE));
            Supplier<String> expected = () -> ADAPTER.apply(start.get());
            Supplier<String> actual = new SupplierBuilder<>(start).append(ADAPTER).build();

            assertEquals(expected.get(), actual.get());
        }
    }

    @Test public void
    test_getReturnsSameAsBuild() throws Exception {

        SupplierBuilder<String> builder = new SupplierBuilder<>(() -> 42).append(ADAPTER);

        assertSame(builder.build(), builder.get());
    }



}