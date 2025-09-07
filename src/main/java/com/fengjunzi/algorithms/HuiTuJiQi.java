package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class HuiTuJiQi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int commandCn = Integer.parseInt(s1.split(" ")[0]);
        int[][] commands = new int[commandCn][2];
        int endPoint = Integer.parseInt(s1.split(" ")[1]);
        for (int i = 0; i < commandCn; i++) {
            String temp = sc.nextLine();
            commands[i][0] = Integer.parseInt(temp.split(" ")[0]);
            commands[i][1] = Integer.parseInt(temp.split(" ")[1]);
        }
        int result = 0;
        int x =0, y = 0;
        x = x + commands[0][0];
        y = y + commands[0][1];
        for (int i = 1; i < commands.length; i++) {
            int xTemp = commands[i][0];
            int yTemp = commands[i][1];
            int xlen = xTemp - x;
            int ylen = Math.abs(y);
            result += xlen * ylen;
            x = xTemp;
            y += yTemp;
        }
        result += Math.abs((endPoint - x)  * y);
        System.out.println(result);
    }
}
