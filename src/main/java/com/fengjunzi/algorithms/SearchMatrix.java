package com.fengjunzi.algorithms;//给你一个满足下述两条属性的 m x n 整数矩阵：
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 1088 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, bottem = m-1, targetLine = -1;
        while(up <= bottem){
            int mid = (up + bottem) >> 1;
            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                targetLine = mid;
                break;
            }else if(matrix[mid][0] >target){
                bottem = mid-1;
            }else{
                up = mid+1;
            }
        }
        if(targetLine == -1){
            return false;
        }
        int left =0, right = n-1;
        while(left <= right){
            int mid = (left + right) >>1;
            if(matrix[targetLine][mid] > target){
                right = mid-1;
            }else if(matrix[targetLine][mid] < target){
                left = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
