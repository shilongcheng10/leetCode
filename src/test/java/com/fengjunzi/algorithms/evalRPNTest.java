package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class evalRPNTest {

    @InjectMocks
    private evalRPN evalRPN;

    @Test
    public void testEvalRPN() {
        System.out.println(evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
