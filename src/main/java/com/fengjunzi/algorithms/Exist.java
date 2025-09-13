package com.fengjunzi.algorithms;//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 2060 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Exist {
    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        trie.insert(word);
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, i, j, dirs, trie, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int[][] dirs, Trie trie, String word, boolean[][] visited) {
        char c = board[x][y];
        if (!trie.children.containsKey(c)) {
            return false;
        }
        trie = trie.children.get(c);
        if (word.equals(trie.word)) {
            return true;
        }
        visited[x][y] = true;
        boolean matched = false;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && !visited[nextX][nextY]) {
                matched |= dfs(board, nextX, nextY, dirs, trie, word, visited);
            }

        }
        visited[x][y] = false;
        return matched;
    }

    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap();
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new Trie());
            }
            cur.word = word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
