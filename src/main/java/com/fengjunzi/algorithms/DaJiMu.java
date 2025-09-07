package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class DaJiMu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted((a, b) -> b-a).collect(Collectors.toList());
        if(input.size() == 1){
            System.out.println(1);
            return;
        }else if(input.size() == 2){
            System.out.println(input.get(0) == input.get(1) ? 2 : 1);
            return;
        }
        int maxLayer = getMaxLayer(input);
        System.out.println(maxLayer);

    }

    private static int getMaxLayer(List<Integer> input) {
        int size = input.size();
        int min = input.get(0);
        int max = input.get(0) + input.get(1);
        int maxLayer = 0;
        for (int length = min; length < max; length++) {
            int layer = 0;
            int left = 0;
            int right = size - 1;
            while (left < size && input.get(left) == length) {
                left++;
                layer++;
            }
            while(left < right){
                if (input.get(left)  + input.get(right) == length) {
                    left++;
                    right--;
                    layer++;
                }else{
                    break;
                }
            }
            if (left == right + 1 && layer > maxLayer) {
                maxLayer = layer;
            }
        }
        return maxLayer;
    }
}
