package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class HuiDuTuCunChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();
        sc.close();
        int[][] matrix = new int[n][m];
        int index = 0;
        for (int i = 2; i < input.length; i+=2) {
            int value = input[i];
            int count = input[i+1];
            for(int j =0; j < count;j++){
                matrix[(j+index) / n][(j + index) % n] = value;
            }
            index += count;
        }
        System.out.println(matrix[targetX][targetY]);
    }
}
