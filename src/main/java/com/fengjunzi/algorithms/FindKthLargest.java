package com.fengjunzi.algorithms;//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2830 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class FindKthLargest {
    //解法1: 大根堆
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i=nums.length-1;i>=nums.length-k+1;i--){
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = left + 1;
        int largest = i;
        if(left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapify(nums, i, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //解法2:双路快排
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n-1, k-1);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        if(left == right){
            return nums[k];
        }
        int pivot = nums[left], i = left-1, j = right+1;
        while(i < j){
            do i++; while (nums[i] > pivot);
            do j--; while (nums[j] < pivot);
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if(k <=j) return quickSort(nums, left, j, k);
        else return quickSort(nums, j+1, right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
