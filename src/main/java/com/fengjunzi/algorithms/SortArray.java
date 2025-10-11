package com.fengjunzi.algorithms;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//解释：请注意，nums 的值不一定唯一。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 1166 👎 0


import java.util.Random;
import java.util.Scanner;

//leetcode submit region begin(Prohibit modification and deletion)
class SortArray {
    // 快速排序 经典
    public int[] quickSortArray(int[] nums) {
        int n = nums.length;
        quickSortOneWay(nums, 0, n-1);
        return nums;
    }

    private void quickSortOneWay(int[] nums, int left, int right) {
        if(left < right) {
            int partiton = getPartition(nums, left, right);
            quickSortOneWay(nums, left, partiton-1);
            quickSortOneWay(nums, partiton+1, right);
        }
    }

    private int getPartition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int i = left -1;
        for(int j = left; j <  right;j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }

    // 双路快排
    public int[] quickSortArray2(int[] nums) {
        int n = nums.length;
        quickSortTwoWay(nums, 0, n-1);
        return nums;
    }

    private void quickSortTwoWay(int[] nums, int left, int right) {
        if(left < right) {
            int partiton = getPartitionTwoWay(nums, left, right);
            quickSortTwoWay(nums, left, partiton-1);
            quickSortTwoWay(nums, partiton+1, right);
        }
    }

    private int getPartitionTwoWay(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int i= left -1, j = right;
        while(true) {
            do i++; while(i< right && nums[i] < pivot);
            do j--; while(j >=left && nums[j] > pivot);
            if(i >= j) {
                break;
            }
            swap(nums, i, j);

        }
        swap(nums, i, right);
        return i;
    }

    //堆排序
    public int[] quickSortArray3(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int len = nums.length-1;
        buildMaxHeapTree(nums, len);
        for (int i = len; i > 0; i--) {
            swap(nums, i, 0);
            len--;
            maxHeapify(nums, 0, len);
        }
    }

    private void buildMaxHeapTree(int[] nums, int len) {
        for(int i = len >>1;i>=0;i--){
            maxHeapify(nums, i, len);
        }
    }

    private void maxHeapify(int[] nums, int i, int len) {
        int lSon = (i<<1) + 1;
        int rSon = (i<<1) +2;
        int large =i;
        if(lSon <=len && nums[lSon] > nums[large]){
            large = lSon;
        }
        if(rSon <=len && nums[rSon] > nums[large]){
            large = rSon;
        }
        if(large != i) {
            swap(nums, i, large);
            maxHeapify(nums, large, len);
        }
    }

    //归并排序
    public int[] quickSortArray4(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len-1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if(nums[mid] < nums[mid+1]) {
            return;
        }
        merge(nums, left, right, mid, temp);
    }

    private void merge(int[] nums, int left, int right, int mid, int[] temp) {
        int i = left, j = mid+1, pointer = 0;
        while (i <= mid && j <= right) {
            if(nums[i] > nums[j]) {
                temp[pointer++] = nums[j++];
            }else{
                temp[pointer++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[pointer++] = nums[i++];
        }
        while (j <= right) {
            temp[pointer++] = nums[j++];
        }
        System.arraycopy(temp,0,nums,left,right-left+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
