package com.fengjunzi.algorithms;//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 564 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class RangeBitwiseAnd {
    public int rangeBitwiseAnd1(int left, int right) {
        int shift = 0;
        while(left < right) {
            left >>=1;
            right >>=1;
            shift++;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        while(left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
