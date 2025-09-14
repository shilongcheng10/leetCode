package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MergeKListsTest {

    @InjectMocks
    private MergeKLists mergeKLists;

    @Test
    public void testMergeKLists() {
        MergeKLists.ListNode root1 = new MergeKLists.ListNode(1);
        root1.next = new MergeKLists.ListNode(4);
        root1.next.next = new MergeKLists.ListNode(5);
        MergeKLists.ListNode root2 = new MergeKLists.ListNode(1);
        root2.next = new MergeKLists.ListNode(3);
        root2.next.next = new MergeKLists.ListNode(4);
        MergeKLists.ListNode root3 = new MergeKLists.ListNode(2);
        root3.next = new MergeKLists.ListNode(6);
        MergeKLists.ListNode[]  lists = new MergeKLists.ListNode[]{root1, root2, root3};
        mergeKLists.
               mergeKLists(lists);
    }
}
