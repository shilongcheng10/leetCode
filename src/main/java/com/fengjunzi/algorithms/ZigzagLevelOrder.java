package com.fengjunzi.algorithms;
//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 974 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        int j =0;
        Deque<TreeNode> nodeDeque = new LinkedList<TreeNode>();
        nodeDeque.offer(root);
        while(!nodeDeque.isEmpty()){
            int n = nodeDeque.size();
            List<Integer> levelRes = new ArrayList<>();
            for(int i = 0; i < n;i++){
                TreeNode node = nodeDeque.poll();
                levelRes.add(node.val);
                if(node.left != null){
                    nodeDeque.add(node.left);
                }
                if(node.right != null){
                    nodeDeque.add(node.right);
                }
            }

            res.add(j % 2 == 0 ? levelRes : levelRes.reversed());
            j++;
        }
        return res;
    }

    //解法： 层序 + Collections.reverse();
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int direction = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(direction == -1) Collections.reverse(list);
            res.add(list);
            direction *= -1;
        }
        return res;
    }
    // 解法： 层序 + 双端队列
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int direction = 1;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Deque<Integer> curLevel = new LinkedList<>();
            int size = queue.size();
            for(int i =0; i < size;i++){
                TreeNode curNode = queue.poll();
                if(direction == 1){
                    curLevel.offerLast(curNode.val);
                }else{
                    curLevel.offerFirst(curNode.val);
                }
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            res.add(new LinkedList<Integer>(curLevel));
            direction *= -1;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
