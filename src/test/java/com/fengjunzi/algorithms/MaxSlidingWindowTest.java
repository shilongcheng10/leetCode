package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxSlidingWindowTest {
    @InjectMocks
    MaxSlidingWindow maxSlidingWindow;
    @Test
    public void maxSlidingWindow() {
        maxSlidingWindow.maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5);
    }
}
