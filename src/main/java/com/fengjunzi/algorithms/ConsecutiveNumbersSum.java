package com.fengjunzi.algorithms;//给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 2
//解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: n = 9
//输出: 3
//解释: 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: n = 15
//输出: 4
//解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数学 枚举 👍 300 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class ConsecutiveNumbersSum {
    //https://leetcode.cn/problems/consecutive-numbers-sum/solutions/1529710/lian-xu-zheng-shu-qiu-he-by-leetcode-sol-33hc/
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        int bound = n*n;
        for(int k =1; k *(k+1) <= bound; k++){
            if(isKConsecutive(n,k)){
                ans++;
            }
        }
        return ans;
    }

    private boolean isKConsecutive(int n, int k) {
        if(k%2 == 1){
            return n %k ==0;
        }else{
            return n %k !=0 && 2 * n %k ==0;
        }
    }

    // 只保留奇数情况考虑
    public int consecutiveNumbersSum2(int n) {
        int ans = 0;
        while(n %2 == 0){
            n >>=1;
        }
        for(int i = 1; i <= n*n; i+=2){
            if(n %i ==0){
                if(i *i ==n){
                    ans++;
                }else{
                    ans+=2;
                }
            }
        }
        return ans;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)
