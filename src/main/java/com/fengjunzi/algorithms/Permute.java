package com.fengjunzi.algorithms;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3176 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(int[] nums, List<Integer> cur, List<List<Integer>> res){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i =0; i < nums.length;i++){
            if(cur.contains(nums[i])){
                continue;
            }
            cur.add(nums[i]);
            backTrace(nums, cur, res);
            cur.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
