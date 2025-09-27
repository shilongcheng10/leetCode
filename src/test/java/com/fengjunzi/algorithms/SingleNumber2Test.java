package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SingleNumber2Test {

    @InjectMocks
    private SingleNumber2 singleNumber2;
    @Test
    public void testSingleNumber() {
        singleNumber2.singleNumber2(new int[]{2,2,3,2});
    }
}
