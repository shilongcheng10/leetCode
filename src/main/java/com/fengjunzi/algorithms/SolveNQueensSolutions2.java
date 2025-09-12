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

import java.util.*;

class SolveNQueensSolutions2 {
    public List<List<String>> solveNQueens(int n) {
        int queens[] = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        dfs(queens, 0, n,result, columns, diagonals1, diagonals2);
        return result;
    }

    public void dfs(int[] queens, int row, int n, List<List<String>> result, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
       if(row == n){
        List<String> oneRes = new ArrayList<>();
         for(int i =0; i < n; i++){

            StringBuilder sb = new StringBuilder();
            for(int j =0; j < n;j++){
                if(j == queens[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            oneRes.add(sb.toString());
         }
         result.add(oneRes);
       }else{
        for(int i =0; i < n;i++){
            if(columns.contains(i)){
                continue;
            }
            int diagonal1 = row - i;
            if(diagonals1.contains(diagonal1)){
                continue;
            }
            int diagonal2 = row + i;
            if(diagonals2.contains(diagonal2)){
                continue;
            }
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            dfs(queens,row+1,n,result,columns,diagonals1, diagonals2);
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
       }
    }

    
}