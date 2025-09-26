package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddBinaryTest {
    @InjectMocks
    private AddBinary addBinary;
    @Test
    public void testAddBinary() {
        System.out.println(addBinary.addBinary("11", "1"));
    }
}
