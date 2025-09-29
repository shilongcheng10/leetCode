package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxPointsTest {
    @InjectMocks
    MaxPoints maxPoints;
    @Test
    public void testMaxPoints() {
        maxPoints.maxPoints(new int[][]{{1,1},{2,2},{3,3}});
    }
}
