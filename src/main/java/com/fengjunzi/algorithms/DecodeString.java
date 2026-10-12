package com.fengjunzi.algorithms;

import java.util.Deque;
import java.util.LinkedList;

class DecodeString {
    public String decodeString(String s) {
        Deque<Character> charStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '['){
                numStack.addFirst(num);
                num =0;
                charStack.addFirst('[');
            }else if(c == ']'){
                StringBuilder sb = new StringBuilder();
                while(!charStack.isEmpty() && charStack.peekFirst() !='['){
                    sb.insert(0, charStack.pollFirst());
                }
                charStack.pollFirst();
                int cnt = numStack.pollFirst();
                for(int i=0; i < cnt;i++){
                    for(int j =0;j < sb.length();j++){
                        charStack.addFirst(sb.charAt(j));
                    }
                }
            }else{
                charStack.addFirst(c);
            }
        }
         StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pollLast());
        }
        return sb.toString();
    }
}