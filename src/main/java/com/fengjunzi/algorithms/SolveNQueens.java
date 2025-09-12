package com.fengjunzi.algorithms;
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2338 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(matrix, 0, n, 0, result);
        return result;
    }

    public void dfs(char[][] matrix, int queenIndex, int n, int index, List<List<String>> result) {
        if (queenIndex == n) {
            List<String> tempResult = new ArrayList<>();
            for (char[] temp : matrix) {
                tempResult.add(new String(temp));
            }
            result.add(tempResult);
            return;
        }
        if (queenIndex < n && (index >= n * n)) {
            return;
        }
        for (int i = index; i < matrix.length * matrix[0].length; i++) {
            int row = i / matrix[0].length;
            int column = i % matrix[0].length;
            if (!existingInSameLine(matrix, row) && !existingInSameColumn(matrix, column)
                    && !existingInSameSlash(matrix, row, column)) {
                matrix[row][column] = 'Q';
                queenIndex++;
                dfs(matrix, queenIndex, n, i+1, result);
                matrix[row][column] = '.';
                queenIndex--;
            }
        }
    }

    public boolean existingInSameLine(char[][] matrix, int i) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 'Q') {
                return true;
            }
        }
        return false;
    }

    public boolean existingInSameColumn(char[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] == 'Q') {
                return true;
            }
        }
        return false;
    }

    public boolean existingInSameSlash(char[][] matrix, int i, int j) {
        int iTemp = i, jTemp = j;
        while (iTemp >= 0 && jTemp >= 0) {
            if (matrix[iTemp--][jTemp--] == 'Q') {
                return true;
            }
        }
        iTemp = i;
        jTemp = j;
        while (iTemp < matrix.length && jTemp < matrix[0].length) {
            if (matrix[iTemp++][jTemp++] == 'Q') {
                return true;
            }
        }
        iTemp = i;
        jTemp = j;
        while (iTemp >= 0 && jTemp < matrix[0].length) {
            if (matrix[iTemp--][jTemp++] == 'Q') {
                return true;
            }
        }
        iTemp = i;
        jTemp = j;
        while (iTemp < matrix.length && jTemp >= 0) {
            if (matrix[iTemp++][jTemp--] == 'Q') {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
