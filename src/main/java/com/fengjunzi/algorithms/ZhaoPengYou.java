package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ZhaoPengYou {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cn = sc.nextInt();
        int[] arr = new int[cn];
        for (int i = 0; i < cn; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] result = new int[cn];
        Stack<Integer> stack = new Stack<>();
        for (int i = cn-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }else{
                result[i] = 0;
            }
            stack.push(i);
        }
        String output = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);

    }
}
