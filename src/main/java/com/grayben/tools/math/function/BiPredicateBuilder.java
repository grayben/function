package com.grayben.tools.math.function;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Incrementally builds a composed bi-predicate.
 * <p>
 * Builds a composed bi-predicate by chaining any number of input adapters
 * into the predicate specified during the construction of an object of this class.
 * <p>
 * Created by Ben Gray on 4/02/2016.
 *
 * @param <X> the type of the first input to the current effective {@link BiPredicate}
 * @param <Y> the type of the second input to the current effective {@link BiPredicate}
 */
public class BiPredicateBuilder<X, Y> implements Supplier<BiPredicate<X, Y>> {

    /**
     * The current effective BiPredicate
     */
    final private BiPredicate<X, Y> biPredicateSoFar;

    /**
     * Constructs a builder based upon the specified bi-predicate.
     * @param biPredicate the bi-predicate upon which to form a composite bi-predicate
     */
    public BiPredicateBuilder(final BiPredicate<X, Y> biPredicate) {

        if (biPredicate == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'biPredicate'");
        }

        this.biPredicateSoFar = biPredicate;
    }

    /**
     * Compose the first input of the current effective bi-predicate with the specified input adapter.
     *
     * @param inputAdapter the input adapter with which to compose the first input to the current effective bi-predicate
     * @param <A> the type of input accepted by the specified input adapter, and hence, the first input
     *           to the new composed bi-predicate
     * @return a new builder holding the new composed bi-predicate
     */
    final public <A> BiPredicateBuilder<A, Y> prependToFirstInput(final Function<? super A, ? extends X> inputAdapter){

        if (inputAdapter == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'inputAdapter'");
        }
        BiPredicate<A, Y> biPredicate = (a, y) -> biPredicateSoFar.test(inputAdapter.apply(a), y);
        return new BiPredicateBuilder<>(biPredicate);
    }

    /**
     * Compose the first input of the current effective bi-predicate with the specified input adapter.
     *
     * @param inputAdapter the input adapter with which to compose the second input to the current effective bi-predicate
     * @param <A> the type of input accepted by the specified input adapter, and hence, the second input
     *           to the new composed bi-predicate
     * @return a new builder holding the new composed bi-predicate
     */
    final public <A> BiPredicateBuilder<X, A> prependToSecondInput(final Function<? super A, ? extends Y> inputAdapter){

        if (inputAdapter == null) {
            throw new NullPointerException("Argument cannot be null; parameter name: 'inputAdapter'");
        }
        BiPredicate<X, A> biPredicate = (x, a) -> biPredicateSoFar.test(x, inputAdapter.apply(a));
        return new BiPredicateBuilder<>(biPredicate);
    }

    /**
     * @return the composed bi-predicate
     */
    final public BiPredicate<X, Y> build(){
        return this.biPredicateSoFar;
    }

    /**
     * @return the same output as {@link #build()}
     */
    @Override
    final public BiPredicate<X, Y> get() {
        return this.build();
    }
}
