package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrangesRottingTest {

    @InjectMocks
    private OrangesRotting orangesRotting;

    @Test
    public void testBuildTree() {
       orangesRotting.orangesRotting(new int[][]{{0,2}});
    }
}
