package com.fengjunzi.algorithms;

public class ReverseWords {
    public String reverseWords(String s){
        StringBuilder sb = trimSpaces(s);
        reverseWords(sb,0, sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        while(start < sb.length()){
            while(end < sb.length() && sb.charAt(end) != ' '){
                end++;
            }
            reverseWords(sb, start, end-1);
            end++;
            start = end;
        }
    }

    private void reverseWords(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') left++;
        while (left < right && s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right;i++){
            char c  = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
        }
        return sb;
    }
}
