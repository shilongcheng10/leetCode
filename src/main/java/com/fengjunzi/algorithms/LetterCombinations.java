package com.fengjunzi.algorithms;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 3122 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2',"abc");
        mapping.put('3',"def");
        mapping.put('4',"ghi");
        mapping.put('5',"jkl");
        mapping.put('6',"mno");
        mapping.put('7',"pqrs");
        mapping.put('8',"tuv");
        mapping.put('9',"wxyz");
        Set<String> ans = new HashSet<>();
        dfs(mapping, digits, new StringBuilder(), 0, ans);
        return new ArrayList<String>(ans);
    }

    public void dfs(Map<Character, String> mapping, String digits, StringBuilder sb, int i, Set<String> ans){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str = mapping.get(digits.charAt(i));
        for(int  j = 0; j < str.length(); j++){
            sb.append(str.charAt(j));
            dfs(mapping, digits, sb, i+1, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
