package com.fengjunzi.algorithms;

import java.util.*;

public class XunZhaoMiMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        Queue<String> queue = new PriorityQueue<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            queue.add(arr[i]);
        }
        int max = 0;
        String result = "";

        while (!queue.isEmpty()){
            String temp = queue.poll();
            int n = temp.length();
            int i;
            for ( i = 1; i < n; i++) {
                if (!list.contains(temp.substring(0, i))){
                    break;
                }
            }
            if (max<=n && i == n){
                max = n;
                result = temp;
            }
        }
        System.out.println(result);
    }
}
