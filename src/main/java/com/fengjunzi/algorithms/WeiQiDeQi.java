package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *https://blog.csdn.net/guorui_java/article/details/138310165
 */
public class WeiQiDeQi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> blackInput = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> whiteInput = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).toList();
        int[][] qipan = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                qipan[i][j] = 0;
            }
        }
        for(int i=0; i < blackInput.size(); i+=2){
            qipan[blackInput.get(i)][blackInput.get(i+1)] = 1;
        }
        for(int i=0; i < whiteInput.size(); i+=2){
            qipan[whiteInput.get(i)][whiteInput.get(i+1)] = 2;
        }
        boolean[][] blackUsed = new boolean[19][19];
        boolean[][] whiteUsed = new boolean[19][19];
        int blackQi = 0, whiteQi = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (qipan[i][j] == 0) {
                    continue;
                }else if(qipan[i][j] == 1) {
                    if(i -1 >=0 && qipan[i-1][j] == 0 && !blackUsed[i-1][j]){
                        blackQi++;
                        blackUsed[i-1][j] = true;
                    }
                    if(j -1 >=0 && qipan[i][j-1] == 0 && !blackUsed[i][j-1]){
                        blackQi++;
                        blackUsed[i][j-1] = true;
                    }
                    if(i+1 <=18 && qipan[i+1][j] == 0 &&!blackUsed[i+1][j]){
                        blackQi++;
                        blackUsed[i+1][j] = true;
                    }
                    if (j+1 <=18 && qipan[i][j+1] == 0 && !blackUsed[i][j+1]){
                        blackQi++;
                        blackUsed[i][j+1] = true;
                    }
                }else if(qipan[i][j] == 2) {
                    if(i -1 >=0 && qipan[i-1][j] == 0 && !whiteUsed[i-1][j]){
                        whiteQi++;
                        whiteUsed[i-1][j] = true;
                    }if(j -1 >=0 && qipan[i][j-1] == 0 && !whiteUsed[i][j-1]){
                        whiteQi++;
                        whiteUsed[i][j-1] = true;
                    }
                    if(i+1 <=18 && qipan[i+1][j] == 0 && !whiteUsed[i+1][j]){
                        whiteQi++;
                        whiteUsed[i+1][j] = true;
                    }
                    if (j+1 <=18 && qipan[i][j+1] == 0 && !whiteUsed[i][j+1]){
                        whiteQi++;
                        whiteUsed[i][j+1] = true;
                    }
                }
            }
        }
        System.out.println(blackQi + " " + whiteQi);
    }
}
