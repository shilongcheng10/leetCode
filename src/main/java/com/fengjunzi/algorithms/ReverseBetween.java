package com.fengjunzi.algorithms;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1978 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseBetween {
    /**
     * get the pre left node and post end Node, and cut the middle node list, and after that reverse middle node and reJoin it after reversed
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        int cn =0;
        ListNode preStart = null, start = null, end = null, postEnd = null;
        while(p != null){
            if(cn == left - 1){
                preStart = p;
            }
            if(cn == left){
                start = p;
            }
            if(cn == right){
                end = p;
            }
            if(cn == right+1){
                postEnd = p;
                break;
            }
            cn++;
            p = p.next;
        }
        preStart.next = null;
        end.next = null;
        ListNode reversed = reverseList(start);
        preStart.next = reversed;
        while(reversed.next!=null){
            reversed = reversed.next;
        }
        reversed.next = postEnd;
        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * use head insert method.
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetweenSolution2(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for(int i =0;i<  right-1-left+1;i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
