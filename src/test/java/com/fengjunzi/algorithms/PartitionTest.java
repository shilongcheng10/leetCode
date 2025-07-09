package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PartitionTest {

    @InjectMocks
    private Partition partition;
    @Test
    public void testPartition() {
        Partition.ListNode listNode = new Partition.ListNode(1);
        listNode.next = new Partition.ListNode(4);
        listNode.next.next = new Partition.ListNode(3);
        listNode.next.next.next = new Partition.ListNode(2);
        listNode.next.next.next.next = new Partition.ListNode(5);
        listNode.next.next.next.next.next = new Partition.ListNode(2);
        partition.partition(listNode,3);
    }
}
