package com.fengjunzi.algorithms;//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 622 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int high = n /10, cur = n %10, low = 0, digit = 1, res =0;
        while(high!=0 || cur!=0) {
            if(cur == 0) res+=high * digit;
            else if (cur == 1) res += high * digit + low +1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high %10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
