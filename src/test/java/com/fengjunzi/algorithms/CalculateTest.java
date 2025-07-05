package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTest {

    @InjectMocks
    private Calculate calculate;
    @Test
    public void testCalculate() {
        System.out.println(calculate.calculate("1 + 1"));
        System.out.println(calculate.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate.calculate("2-1 + 2"));
    }
}
