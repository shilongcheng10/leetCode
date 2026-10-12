package com.fengjunzi.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

class Calculate2 {
    public int calculate(String s) {
        Deque<Integer> digitStack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        s = s.replaceAll(" ", "");
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(!Character.isDigit(c) || i ==  s.length() - 1) {
                switch (preSign) {
                    case '+': digitStack.push(num); break;
                    case '-': digitStack.push(-num); break;
                    case '*': digitStack.push(digitStack.pop() * num); break;
                    case '/': digitStack.push(digitStack.pop() / num); break;
                }
                preSign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!digitStack.isEmpty()) {
            res += digitStack.pop();
        }
        return res;
    }
}