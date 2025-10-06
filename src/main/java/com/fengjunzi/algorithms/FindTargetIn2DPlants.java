package com.fengjunzi.algorithms;//m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
//
// 
// 每行中，每棵植物的右侧相邻植物不矮于该植物； 
// 每列中，每棵植物的下侧相邻植物不矮于该植物。 
// 
//
// 
//
// 请判断 plants 中是否存在目标高度值 target。 
//
// 
//
// 示例 1： 
//
// 
//输入：plants = [[2,3,6,8],[4,5,8,9],[5,9,10,12]], target = 8
//
//输出：true
// 
//
// 
//
// 示例 2： 
//
// 
//输入：plants = [[1,3,5],[2,5,7]], target = 4
//
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 1000 
// 0 <= m <= 1000 
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
//
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1039 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class FindTargetIn2DPlants {
    // 二分查找， 时间复杂度OM(logn)
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int m = plants.length;
        int n = plants[0].length;
        for(int i = 0; i < m; i++) {
            if(plants[i][n-1] < target){
                continue;
            }
            int left =0, right = n-1;
            while(left <= right) {
                int mid = (left+right)>>1;
                if (plants[i][mid] == target) {
                    return true;
                }else if (plants[i][mid] > target) {
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return false;
    }
    // 二叉搜索树
    public boolean findTargetIn2DPlants2(int[][] plants, int target) {
        int i = plants.length -1, j =0;
        while(i>=0 && j < plants[0].length){
            if(plants[i][j] > target){
                i--;
            }else if(plants[i][j] < target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
