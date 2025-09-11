package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class 报数游戏约瑟夫环 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n <= 1 || n >= 100) {
            System.out.println("ERROR！");
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 101; i++) {
            map.put(i, i);
        }
        int start = 1;
        while (map.size() >= n) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                if (start == n) {
                    iterator.remove();
                    start = 1;
                } else {
                    start++;
                }
            }
        }
        String result = map.keySet().stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
    }


}
