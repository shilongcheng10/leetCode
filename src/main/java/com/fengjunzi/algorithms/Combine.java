package com.fengjunzi.algorithms;//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1796 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(1, n, k, result, new ArrayList<Integer>());
        return result.stream().toList();
    }

    public void backTrace(int cur, int n, int k, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        backTrace(cur + 1, n, k, result, temp);
        temp.removeLast();
//        backTrace(cur + 1, n, k, result, temp);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
