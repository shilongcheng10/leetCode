package com.fengjunzi.algorithms;//给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false：
//
// 一个 好的子数组 是： 
//
// 
// 长度 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 注意： 
//
// 
// 子数组 是数组中 连续 的部分。 
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 数学 前缀和 👍 638 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2){
            return false;
        }
        int[] preFixSum = new int[n+1];
        preFixSum[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            preFixSum[i] = preFixSum[i-1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<=n;i++){
            int mod = preFixSum[i] % k;
            if(map.containsKey(mod)){
                if (i - map.get(mod) >= 2){
                    return true;
                }
            }else{
                map.put(mod,i);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
