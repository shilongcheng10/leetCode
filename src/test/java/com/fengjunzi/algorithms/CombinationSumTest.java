package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CombinationSumTest {

    @InjectMocks
    private CombinationSum combinationSum;

    @Test
    public void testCombinationSum() {
       combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
