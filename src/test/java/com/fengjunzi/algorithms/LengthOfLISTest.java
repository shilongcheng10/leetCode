package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LengthOfLISTest {
    @InjectMocks
    LengthOfLIS lengthOfLIS;
    @Test
    public void test() {
        lengthOfLIS.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
