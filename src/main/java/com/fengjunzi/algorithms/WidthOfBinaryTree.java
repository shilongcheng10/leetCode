package com.fengjunzi.algorithms;//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
class WidthOfBinaryTree {
    //广度优先遍历加序列号
    public int widthOfBinaryTree(TreeNode root) {
        int maxSize = Integer.MIN_VALUE;
        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(root, 1));
        while(!list.isEmpty()){
            List<Pair<TreeNode, Integer>> tempList = new ArrayList<>();
            for(Pair<TreeNode, Integer> item : list){
                TreeNode node = item.getKey();
                Integer index = item.getValue();
                if(node.left != null){
                    tempList.add(new Pair<>(node.left, index<<1));
                }
                if(node.right != null){
                    tempList.add(new Pair<>(node.right, (index<<1) +1));
                }
            }
            maxSize = Math.max(maxSize, list.getLast().getValue() - list.getFirst().getValue() + 1);
            list = tempList;
        }
        return maxSize;
    }

    //深度优先遍历 + 序列号
    public int widthOfBinaryTree1(TreeNode root) {
        return dfs(new HashMap<>(), root, 1, 1);
    }

    public int dfs(Map<Integer, Integer> map, TreeNode node, int depth, int index){
        if(node == null){
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) +1, Math.max(dfs(map, node.left, depth + 1, index<<1), dfs(map, node.right, depth + 1, (index<<1)+1)));

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
