package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class HuangDaoQiuSheng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> positiveStack = new Stack<>();
        Stack<Integer> negativeStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  > 0) {
                positiveStack.push(arr[i]);
            }else{
                int remainNum = -arr[i];
                while(!positiveStack.isEmpty()){
                    int positive_top = positiveStack.peek();
                    if(positive_top > remainNum){
                        Integer pop = positiveStack.pop();
                        pop -= remainNum;
                        positiveStack.push(pop);
                        remainNum = 0;
                        break;
                    }else if(positive_top < remainNum){
                        Integer pop = positiveStack.pop();
                        remainNum -= pop;
                    }else{
                        positiveStack.pop();
                        remainNum =0;
                        break;
                    }
                }
                if(remainNum  > 0){
                    negativeStack.push(-remainNum);
                }

            }
        }
        System.out.println(negativeStack.size() + positiveStack.size());
    }
}
