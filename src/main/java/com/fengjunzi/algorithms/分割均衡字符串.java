package com.fengjunzi.algorithms;

import java.util.Scanner;

public class 分割均衡字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = maxBalancedSubStrings(str);
        System.out.println(result);
    }

    private static int maxBalancedSubStrings(String str) {
        int countX = 0;
        int countY = 0;
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                countX++;
            }
            if (str.charAt(i) == 'Y') {
                countY++;
            }
            if (countX == countY) {
                balance++;
                countX = 0;
                countY = 0;
            }
        }
        return balance;
    }
}
