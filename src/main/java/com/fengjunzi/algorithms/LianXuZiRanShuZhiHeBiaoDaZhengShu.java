package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class LianXuZiRanShuZhiHeBiaoDaZhengShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i +1;
        List<int[]> list = new ArrayList<>();
        int left =0;
        int right = 1;

        int sum = arr[left];
        while (left < n && right <= n) {
            if (sum > n){
                sum -= arr[left++];
            }else if (sum == n){
                int[] oks = Arrays.copyOfRange(arr, left, right);
                list.add(oks);
                sum -= arr[left++];
            }else{
                if (right < n){
                    sum+=arr[right++];
                }else{
                    sum -= arr[left++];
                }
            }
        }
        list.sort(Comparator.comparing(i -> i.length));
        for (int i = 0; i < list.size(); i++) {
            String temp = Arrays.stream(list.get(i)).mapToObj(String::valueOf).collect(Collectors.joining("+"));
            System.out.println(n +"=" +  temp);
        }
        System.out.println("Result:" + list.size());
    }
}
