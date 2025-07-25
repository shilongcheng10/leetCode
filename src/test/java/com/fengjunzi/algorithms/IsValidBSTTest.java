package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsValidBSTTest {

    @InjectMocks
    private IsValidBST isValidBST;

    @Test
    public void testIsValidBST() {
        IsValidBST.TreeNode treeNode = new IsValidBST.TreeNode(5);
        treeNode.left = new IsValidBST.TreeNode(4);
        treeNode.right = new IsValidBST.TreeNode(6);
        treeNode.right.left = new IsValidBST.TreeNode(3);
        treeNode.right.right = new IsValidBST.TreeNode(7);
        isValidBST.isValidBST(treeNode);
    }
}
