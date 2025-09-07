package com.fengjunzi.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class ZiFuChuanXiaoChu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() || ch != stack.peek()) {
                stack.push(ch);
            }else {
                stack.pop();
            }
        }

        System.out.println(stack.size());
    }
}
