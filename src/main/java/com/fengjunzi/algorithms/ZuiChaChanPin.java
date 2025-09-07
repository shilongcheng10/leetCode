package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class ZuiChaChanPin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] products = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            deque.add(products[i]);
            min = Math.min(min, products[i]);
        }
        List<Integer> output = new ArrayList<>();
        output.add(min);
        System.out.print(min + ",");
        for (int i = count; i < products.length; i++) {
            Integer removed = deque.removeFirst();
            deque.addLast(products[i]);
            if (removed == min){
                min = deque.stream().min(Comparator.comparingInt(Integer::intValue)).get();
            }else{
                min = Math.min(min, products[i]);
            }
            output.add(min);
        }
        System.out.println(output.stream().map(Object::toString).collect(Collectors.joining(",")));

    }
}
