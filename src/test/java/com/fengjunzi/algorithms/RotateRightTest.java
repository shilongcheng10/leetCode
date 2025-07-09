package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RotateRightTest {

    @InjectMocks
    private RotateRight rotateRight;
    @Test
    public void testRotateRight() {
        RotateRight.ListNode listNode1 = new RotateRight.ListNode(1);
        listNode1.next = new RotateRight.ListNode(2);
        listNode1.next.next = new RotateRight.ListNode(3);
        listNode1.next.next.next = new RotateRight.ListNode(4);
        listNode1.next.next.next.next = new RotateRight.ListNode(5);
        rotateRight.rotateRight(listNode1, 2);

    }
}
