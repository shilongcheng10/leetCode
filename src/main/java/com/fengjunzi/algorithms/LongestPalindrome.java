package com.fengjunzi.algorithms;//给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7834 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindrome {
    //二维动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i =0; i < n;i++){
            dp[i][i] =true;
            int pre = i-1;
            while(pre >=0 && s.charAt(pre) == s.charAt(i)){
                dp[pre][i] = true;
                pre--;
            }
            int next = i+1;
            while(next < n && s.charAt(i) == s.charAt(next)){
                dp[i][next] = true;
                next++;
            }
            while(pre >=0 && next < n && s.charAt(pre) == s.charAt(next)){
                dp[pre][next] = true;
                pre--;
                next++;
            }
        }
        int left = 0, right = 0, max =1;
        for(int i=0; i < n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j] && max < j-i+1){
                    left =i;
                    right = j;
                    max = j-i+1;
                }
            }
        }
        return s.substring(left, right+1);
    }

    //中心扩散法
    public String longestPalindrome2(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i< s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);

    }

    public int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right - left - 1;
    }

    // 末尾扫描动态规划
    public String longestPalindrome3(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int maxLen = 0;
        String str = "";
        char[] charArray = s.toCharArray();
        for(int i = len-1; i >=0;i--){
            for(int j = i; j < len;j++){
                if(charArray[i] == charArray[j] && ((j - i <=1 || dp[i+1][j-1]))){
                    dp[i][j] = true;
                    maxLen = Math.max(j-i, maxLen);
                    str = j-i >= maxLen ? s.substring(i, j+1) : str;
                }
            }
        }
        return str;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
