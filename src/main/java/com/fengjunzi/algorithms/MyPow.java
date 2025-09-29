package com.fengjunzi.algorithms;
//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// 要么 x 不为零，要么 n > 0 。 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyPow {
    public double myPow(double x, int n) {
        long N= n;
        return N>=0 ? myQuickPow(x, N) : 1.0/myQuickPow(x, -N);
    }

    private double myQuickPow(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        double y = myQuickPow(x, n / 2);
        return n %2 == 0 ? y*y : y*y*x;
    }

    public double quickMul(double x, long N){
        double ans = 1.0;
        double x_con = x;
        while(N >0){
            if(N % 2 == 1){
                ans *= x_con;
            }
            x_con *=x_con;
            N>>=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
