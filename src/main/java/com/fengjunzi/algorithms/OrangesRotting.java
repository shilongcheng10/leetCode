package com.fengjunzi.algorithms;//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 1057 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<int[][]> queue = new LinkedList<>();

        int xlength = grid[0].length;
        int ylength = grid.length;
        boolean[][] visisted = new boolean[ylength][xlength];
        boolean existingFresh = false;
        boolean existingRotting = false;
        for(int i =0; i < ylength; i++){
            for(int j = 0 ; j < xlength;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[][]{{i,j}});
                    visisted[i][j] = true;
                    existingRotting = true;
                }
                if(grid[i][j] == 1){
                    existingFresh = true;
                }
            }
        }
        if(existingFresh && !existingRotting){
            return -1;
        }
        if(!existingFresh && !existingRotting){
            return 0;
        }
        int mins = -1;


        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n;i++){
                int[][] pos = queue.poll();
                int x = pos[0][0];
                int y = pos[0][1];
                if(x -1 >=0 && x-1 <ylength && grid[x-1][y] == 1 && !visisted[x-1][y]){
                    queue.add(new int[][]{{x-1, y}});
                    visisted[x-1][y] = true;
                }
                if(x +1 >=0 && x+1 <ylength && grid[x+1][y] == 1 && !visisted[x+1][y]){
                    queue.add(new int[][]{{x+1, y}});
                    visisted[x+1][y] = true;
                }
                if(y -1 >=0 && y-1 <xlength && grid[x][y-1] == 1 && !visisted[x][y-1]){
                    queue.add(new int[][]{{x, y-1}});
                    visisted[x][y-1] = true;
                }
                if(y +1 >=0 && y+1 <xlength && grid[x][y+1] == 1 && !visisted[x][y+1]){
                    queue.add(new int[][]{{x, y+1}});
                    visisted[x][y+1] = true;
                }
            }
            mins++;
        }
        for(int i = 0 ; i < visisted.length;i++){
            for(int j = 0; j < visisted[0].length;j++){
                if(grid[i][j]!=0 && !visisted[i][j]){
                    return -1;
                }
            }
        }
        return mins;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
