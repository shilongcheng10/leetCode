package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BuildTree2Test {

    @InjectMocks
    private BuildTree2 buildTree2;

    @Test
    public void testBuildTree() {
       buildTree2.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
