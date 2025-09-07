package com.fengjunzi.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class BiaoDaShiKuoHaoPiPei {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inStr = input.nextLine();
        inStr = inStr.replaceAll(" ", "");
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < inStr.length(); i++) {
            char ch = inStr.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }else if (ch == ')') {
                stack.pop();
                result++;
            }
        }
        System.out.println(!stack.isEmpty() ? -1 : result);
    }
}
