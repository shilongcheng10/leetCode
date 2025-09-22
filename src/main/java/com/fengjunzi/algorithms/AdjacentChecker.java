package com.fengjunzi.algorithms;

public class AdjacentChecker {
    private int[] pos;

    public AdjacentChecker(int[] arr) {
        int n = arr.length;
        pos = new int[n+1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] =i;
        }
    }
    public boolean isAdjacent(int a, int b) {
        if (a <= 0 || a >= pos.length || b <= 0 || b >= pos.length) {
            throw new IllegalArgumentException("值超出范围");
        }
        return Math.abs(pos[a]-pos[b]) == 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5}; // 是 1..5 的排列
        AdjacentChecker checker = new AdjacentChecker(arr);

        System.out.println(checker.isAdjacent(3, 1)); // true (3 在 idx0, 1 在 idx1)
        System.out.println(checker.isAdjacent(1, 4)); // false
        System.out.println(checker.isAdjacent(2, 5)); //
    }
}
