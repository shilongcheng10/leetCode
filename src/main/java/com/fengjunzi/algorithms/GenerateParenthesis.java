package com.fengjunzi.algorithms;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3922 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        dfs(n, new StringBuilder(), 0, 0, result);
        return result;
    }

    private void dfs(int n,StringBuilder sb, int leftCn, int rightCn, List<String> result) {
       if(sb.length() == n*2){
           result.add(sb.toString());
           return;
       }
       if(leftCn < n){
           sb.append("(");
           dfs(n, sb, leftCn+1, rightCn, result);
           sb.deleteCharAt(sb.length()-1);
       }
       if (rightCn < leftCn){
           sb.append(")");
           dfs(n, sb, leftCn, rightCn + 1, result);
           sb.deleteCharAt(sb.length()-1);
       }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
