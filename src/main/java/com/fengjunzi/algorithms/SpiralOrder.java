package com.fengjunzi.algorithms;//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 2002 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if (matrix==null||row==0||col==0) {
            return res;
        }
        int directions[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        int x = 0, y = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row * col; i++) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            int nextX = x + directions[directionIndex][0];
            int nextY = y + directions[directionIndex][1];
            if (nextX<0 || nextX>=row || nextY<0 || nextY>=col || visited[nextX][nextY]) {
                directionIndex= (directionIndex+1)%4;
            }
            x += directions[directionIndex][0];
            y += directions[directionIndex][1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
