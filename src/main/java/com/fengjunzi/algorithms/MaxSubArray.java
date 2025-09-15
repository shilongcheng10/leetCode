package com.fengjunzi.algorithms;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 7132 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for(int x : nums){
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public class Status{
        int lsum, rsum, msum, isum;
        public Status(int lsum, int rsum, int msum, int isum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
            this.isum = isum;
        }
    }
    public int maxSubArraySolution2(int[] nums) {
        return getInfo(nums, 0, nums.length-1).msum;
    }
    public Status getInfo(int[] nums, int l, int r){
        if(l == r){
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l +r) >> 1;
        Status lSub = getInfo(nums, l, m);
        Status rSub = getInfo(nums, m+1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status lSub, Status rSub){
        int iSum = lSub.isum + rSub.isum;
        int lSum = Math.max(lSub.lsum, lSub.isum + rSub.lsum);
        int rSum = Math.max(rSub.rsum, rSub.isum + lSub.rsum);
        int mSum = Math.max(Math.max(lSub.msum, rSub.msum), lSub.rsum + rSub.lsum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
