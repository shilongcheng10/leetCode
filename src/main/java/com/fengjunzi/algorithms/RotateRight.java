package com.fengjunzi.algorithms;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1142 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k == 0){
            return head;
        }
        ListNode p = head;
        int len = 0;
        while(p!=null){
            p = p.next;
            len++;
        }
        int rotateLen = len-(k % len);
        if(rotateLen == len){
            return head;
        }
        ListNode p1 = head;
        for(int i = 0; i < rotateLen-1;i++){
            p1 = p1.next;
        }
        ListNode temp = p1;
        ListNode newHead = temp.next;

        while(p1.next!=null){
            p1 = p1.next;
        }
        p1.next = head;
        temp.next = null;
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
