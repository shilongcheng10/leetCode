package com.fengjunzi.algorithms;//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
//
// 
// 连接：一个单元格与水平或垂直方向上相邻的单元格连接。 
// 区域：连接所有 'O' 的单元格来形成一个区域。 
// 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。 
// 
//
// 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
// 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]] 
// 
//
// 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] 
//
//
// 解释： 
// 
// 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。 
//
// 示例 2： 
//
// 
// 输入：board = [["X"]] 
// 
//
// 输出：[["X"]] 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1225 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solve {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int row = board.length;
        int column = board[0].length;
        for(int i = 0; i < row;i++){
            dfs(board, i, 0);
            dfs(board, i, column - 1);
        }
        for(int i = 1; i < column-1;i++){
            dfs(board, 0, i);
            dfs(board, row-1, i);
        }
        for(int i = 0; i < row;i++){
            for(int j =0; j < column;j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j ){
        int row = board.length;
        int column = board[0].length;
        if(i < 0|| i >= row || j <0 || j >= column || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
