package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BinaryTreePathsTest {
    @InjectMocks
    private BinaryTreePaths binaryTreePaths;

    @Test
    public void test() {
        BinaryTreePaths.TreeNode root = new BinaryTreePaths.TreeNode(1);
        root.left = new BinaryTreePaths.TreeNode(2);
        root.right = new BinaryTreePaths.TreeNode(3);
        root.left.right = new BinaryTreePaths.TreeNode(5);
        binaryTreePaths.binaryTreePaths(root);
    }
}
