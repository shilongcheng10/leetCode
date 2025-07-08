package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ReverseKGroupTest {

    @InjectMocks
    private ReverseKGroup reverseKGroup;

    @Test
    public void testEvalRPN() {
        ReverseKGroup.ListNode listNode = new ReverseKGroup.ListNode(1);
        listNode.next = new ReverseKGroup.ListNode(2);
        listNode.next.next = new ReverseKGroup.ListNode(3);
        listNode.next.next.next = new ReverseKGroup.ListNode(4);
        listNode.next.next.next.next = new ReverseKGroup.ListNode(5);
        reverseKGroup.reverseKGroup(listNode, 2);
    }
}
