package com.fengjunzi.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class ZuiDaKuoHaoShenDu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int maxResult = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                    result++;
                    maxResult = Math.max(maxResult, result);

                stack.push(c);
            }else if (c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    result--;
                    stack.pop();
                }else{
                    System.out.println(0);
                    return;
                }
            }else if (c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    result--;
                    stack.pop();
                }else{
                    System.out.println(0);
                    return;
                }
            }else if (c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    result--;
                    stack.pop();
                }else{
                    System.out.println(0);
                    return;
                }
            }else{
                System.out.println("input error");
                return;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : maxResult);
    }
}
