package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxSubarraySumCircularTest {
    @InjectMocks
    MaxSubarraySumCircular maxSubarraySumCircular;
    @Test
    public void maxSubarraySumCircular() {
        maxSubarraySumCircular.maxSubarraySumCircular(new int[]{5,-3,5});
    }
}
