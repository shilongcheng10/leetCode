package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CombineTest {

    @InjectMocks
    private Combine combine;

    @Test
    public void testCombine() {
        combine.combine(4, 2);
    }
}
