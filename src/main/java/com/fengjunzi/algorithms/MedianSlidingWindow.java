package com.fengjunzi.algorithms;//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
//
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 515 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        DualHeap heap = new DualHeap(k);
        for (int i = 0;i < k; i++){
            heap.insert(nums[i]);
        }
        double[] res = new double[n-k+1];
        res[0] = heap.getMedian();
        for(int i =k; i <n;i++){
            heap.insert(nums[i]);
            heap.erase(nums[i-k]);
            res[i-k+1] =  heap.getMedian();
        }
        return res;
    }
    class DualHeap{
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private int smallSize;
        private int largeSize;
        private int k;
        private Map<Integer, Integer> delayed;

        public DualHeap(int k) {
            this.k = k;
            this.small = new PriorityQueue<>(Comparator.reverseOrder());
            this.large = new PriorityQueue<>();
            this.smallSize = 0;
            this.largeSize = 0;
            this.delayed = new HashMap<>();
        }

        public void insert(int num) {
            if(small.isEmpty() || num <= small.peek()){
                small.offer(num);
                smallSize++;
            }else{
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }
        public void erase(int num){
            delayed.put(num, delayed.getOrDefault(num, 0) +1);
            if(num <= small.peek()){
                smallSize--;
                if(num == small.peek()){
                    prune(small);
                }
            }else{
                largeSize--;
                if(num == large.peek()){
                    prune(large);
                }
            }
            makeBalance();
        }

        public double getMedian() {
            return (k & 1) ==1 ? small.peek() : ((double)small.peek() + large.peek())/2;
        }
        private void makeBalance(){
            if(smallSize > largeSize+1){
                large.offer(small.poll());
                largeSize++;
                smallSize--;
                prune(small);
            }else if(smallSize < largeSize){
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }
        private void prune(PriorityQueue<Integer> pq){
            while(!pq.isEmpty()){
                int num = pq.peek();
                if(delayed.containsKey(num)){
                    delayed.put(num, delayed.get(num) -1);
                    if(delayed.get(num) == 0){
                        delayed.remove(num);
                    }
                    pq.poll();
                }else{
                    break;
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
