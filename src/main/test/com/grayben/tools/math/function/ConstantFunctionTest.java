package com.grayben.tools.math.function;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ben Gray on 2/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantFunctionTest {

    @Test
    public void test_applyReturnsConstant_onNumerousRandomisedInputs
            () throws ExceptionIncludingMockitoWarnings {
        final Double piConstant = Math.PI;
        final ConstantFunction<Object, Double> piConstantFunction = new ConstantFunction<>(piConstant);
        final List<Object> inputList = new ArrayList<>();
        for(int i = 0; i < 10000000; i++){
            inputList.add(RandomUtils.nextInt(0, Integer.MAX_VALUE) - RandomUtils.nextInt(0, Integer.MAX_VALUE));
            inputList.add(RandomUtils.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE));
            inputList.add(RandomUtils.nextFloat(Float.MIN_VALUE, Float.MAX_VALUE));
            inputList.add(RandomUtils.nextLong(0, Long.MAX_VALUE) - RandomUtils.nextLong(0, Long.MAX_VALUE));
            inputList.add(RandomStringUtils.random(255));
        }
        Double[] expectedResults = new Double[inputList.size()];
        Double[] actualResults = new Double[inputList.size()];
        for(int i = 0; i < expectedResults.length; i++)
            expectedResults[i] = piConstant;
        for(int i = 0; i < actualResults.length; i++)
            actualResults[i] = piConstantFunction.apply(inputList.get(i));

        assertArrayEquals(expectedResults, actualResults);
    }
}