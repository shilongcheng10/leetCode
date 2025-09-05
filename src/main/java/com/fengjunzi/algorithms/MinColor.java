package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MinColor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0){
                    nums[j] = nums[i];
                }
            }
        }
        System.out.println(Arrays.stream(nums).distinct().count());
    }
}
