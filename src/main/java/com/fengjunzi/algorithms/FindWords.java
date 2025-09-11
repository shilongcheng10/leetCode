package com.fengjunzi.algorithms;//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
// 
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 956 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class FindWords {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, result);
            }
        }
        return new ArrayList<String>(result);
    }

    public void dfs(char[][] board, Trie trie, int i, int j, Set<String> result) {
        if(!trie.children.containsKey(board[i][j])) {
            return;
        }
        char c = board[i][j];
        trie = trie.children.get(c);
        if(!"".equals(trie.word)){
            result.add(trie.word);
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >=0 && x < board.length && y >=0 && y < board[0].length){
                dfs(board, trie, x, y, result);
            }
        }
        board[i][j] = c;
    }
    class Trie{
        String word;
        Map<Character, Trie> children;

        public Trie(){
            this.word = "";
            this.children = new HashMap<>();
        }
        public void insert(String word){
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
