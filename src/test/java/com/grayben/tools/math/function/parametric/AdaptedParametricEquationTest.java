package com.grayben.tools.math.function.parametric;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by Ben Gray on 2/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdaptedParametricEquationTest {

    @Test
    public void test_applyReturnsExpectedOutput_onArbitraryIntegerInput
            () throws ExceptionIncludingMockitoWarnings {
        Integer input = 401;
        Function<Integer, Double> squareRootFunction = Math::sqrt;
        ParametricEquation<Double, Integer, Double> wholeAndPart = aDouble -> {
            double myDouble = aDouble;
            Integer wholePart = (int) myDouble;
            Double fractionalPart = myDouble - wholePart;
            return new ImmutablePair<>(wholePart, fractionalPart);
        };
        AdaptedParametricEquation<Integer, Double, Integer, Double> adaptedParametricEquation
                = new AdaptedParametricEquation<>(squareRootFunction, wholeAndPart);
        assertEquals(wholeAndPart.apply(squareRootFunction.apply(input)), adaptedParametricEquation.apply(input));
    }
}