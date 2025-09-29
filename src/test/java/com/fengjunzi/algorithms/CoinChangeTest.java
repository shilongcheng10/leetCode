package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoinChangeTest {
    @InjectMocks
    private CoinChange coinChange;
    @Test
    public void test() {
        coinChange.coinChange(new int[]{1,2,5}, 11);
    }
}
