package com.fengjunzi.algorithms;//字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1477 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> roadMap = new HashMap<>();
        wordList.add(beginWord);
        for(String s: wordList){
            char[] charArr = s.toCharArray();
            for(int i = 0;i < s.length();i++){
                char t = charArr[i];
                charArr[i] = '*';
                String change = new String(charArr);
                roadMap.computeIfAbsent(change, k -> new ArrayList<>()).add(s);
                roadMap.computeIfAbsent(s, k -> new ArrayList<>()).add(change);
                charArr[i] = t;

            }
        }
        if(!roadMap.containsKey(endWord)){
            return 0;
        }
        int ans =0;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size;i++){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return ans / 2 + 1;
                }
                if(roadMap.containsKey(cur)){
                    for(String s : roadMap.get(cur)){
                        if(visit.contains(s)){
                            continue;
                        }
                        visit.add(s);
                        queue.offer(s);
                    }
                }
            }
            ans++;
        }
        return 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
