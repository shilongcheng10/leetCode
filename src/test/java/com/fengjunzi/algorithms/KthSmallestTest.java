package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KthSmallestTest {

    @InjectMocks
    private KthSmallest kthSmallest;

    @Test
    public void testKsmallest() {
        KthSmallest.TreeNode root = new KthSmallest.TreeNode(3);
        root.left = new KthSmallest.TreeNode(1);
        root.right = new KthSmallest.TreeNode(4);
        root.left.right = new KthSmallest.TreeNode(2);
        kthSmallest.kthSmallest(root, 1);
    }
}
