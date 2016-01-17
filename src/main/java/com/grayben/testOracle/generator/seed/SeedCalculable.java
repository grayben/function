package com.grayben.testOracle.generator.seed;

/**
 * Created by beng on 17/01/2016.
 */
public interface SeedCalculable<S1, S2> {
    S2 calculateSeed(S1 seed1);
}
