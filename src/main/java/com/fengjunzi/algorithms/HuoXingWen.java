package com.fengjunzi.algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://blog.csdn.net/guorui_java/article/details/139705106
 */
public class HuoXingWen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Stack<Character> charStack = new Stack<>();
        Stack<Long> numStack = new Stack<>();
        int point = 0;
        while (point < str.length()) {
           char c = str.charAt(point);
           if(Character.isDigit(c)){
               StringBuilder stringBuilder = new StringBuilder();
               while(point<str.length() && Character.isDigit(str.charAt(point))){
                   stringBuilder.append(str.charAt(point++));
               }
               numStack.push(Long.parseLong(stringBuilder.toString()));
           }else{
               while (!charStack.isEmpty() && precedence(c) < precedence(charStack.peek())){
                    long num1 = numStack.pop();
                    long num2 = numStack.pop();
                   char oper = charStack.pop();
                   numStack.push(calculate(num1,num2,oper));
               }
               charStack.push(c);
               point++;
           }
        }
        while (!charStack.isEmpty()){
            long num1 = numStack.pop();
            long num2 = numStack.pop();
            char oper = charStack.pop();
            numStack.push(calculate(num1,num2,oper));
        }
        System.out.println(numStack.pop());
    }

    private static long calculate(long num1, long num2, char ch) {
        if (ch == '#'){
            return 4 * num2 + 3 * num1 + 2;
        }else if (ch == '$'){
            return 2 * num2 +  num1 + 3;
        }
        return 0;

    }

    private static int precedence(char ch) {
        if (ch == '#') {
            return 2;
        }
        if (ch >= '$') {
            return 1;
        }
        return 0;
    }
}
