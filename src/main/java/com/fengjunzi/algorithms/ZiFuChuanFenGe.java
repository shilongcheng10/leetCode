package com.fengjunzi.algorithms;

import java.util.Scanner;


public class ZiFuChuanFenGe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] arr = str.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("-");
        for (int i = 1; i < arr.length; i++) {
            int length = arr[i].length();
            int lowerCaseCn =0;
            int upperCaseCn =0;
            StringBuilder sb1 = new StringBuilder();
            for (int j = 0; j < length; j++){
                sb1.append(arr[i].charAt(j));
                if (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'z') {
                    lowerCaseCn++;
                }else if (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'Z') {
                    upperCaseCn++;
                }
                if((j + 1) % n == 0 || j == length - 1){
                    if (lowerCaseCn < upperCaseCn){
                        sb.append((sb1.toString().toUpperCase())).append("-");
                    }else if (lowerCaseCn > upperCaseCn){
                        sb.append((sb1.toString().toLowerCase())).append("-");
                    }else{
                        sb.append(sb1).append("-");
                    }
                    sb1 = new StringBuilder();
                    lowerCaseCn = 0;
                    upperCaseCn = 0;
                }

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
