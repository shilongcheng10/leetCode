package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxSubArrayTest {

    @InjectMocks
    private MaxSubArray maxSubArray;

    @Test
    public void testMaxSubArray() {
       maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
