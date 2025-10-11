package com.fengjunzi.algorithms;//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 1000 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for(int i =0; i < nums1.length;i++){
            for(int j = 0; j < nums2.length;j++){
                if(!res.contains(nums2[j]) && nums2[j] == nums1[i]){
                    res.add(nums1[i]);
                    break;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1 = 0, p2 = 0;
        List<Integer> res = new ArrayList<>();
        while (p1 < n1 && p2 < n2) {
            int num1 = nums1[p1], num2 = nums2[p2];
            if (num1 == num2) {
                if (res.isEmpty() || res.getLast() != num1) {
                    res.add(num1);
                }
                p1++;
                p2++;
            }else if(num1 < num2){
                p1++;
            }else{
                p2++;
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

}
//leetcode submit region end(Prohibit modification and deletion)
