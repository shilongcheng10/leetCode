package com.fengjunzi.algorithms;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/guorui_java/article/details/133952168
 */
public class DuiZhanZhongShengYuDeShuZi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
              int current = arr[i];
              if(list.isEmpty()){
                  list.add(current);
                  continue;
              }
              List<Integer> temp = new ArrayList<>();
              int sum =0;
              boolean flag = false;
              for (int j = list.size()-1;j>=0;j--){
                  int peek = list.get(j);

                  sum+=peek;
                  if (sum>current){
                      list.add(current);
                      flag = true;
                      break;
                  }
                  if (sum==current){
                      temp.add(peek);
                      for (int k = 0;k<temp.size();k++){
                          list.removeLast();
                      }
                      list.add(current *2);
                      flag = true;
                      break;
                  }else{
                      temp.add(peek);
                  }
              }
              if(!flag){
                  list.add(current);
              }

        }
        StringBuilder sb = new StringBuilder();
        for (int j = list.size()-1;j>=0;j--){
            sb.append(list.get(j)+" ");
        }
        System.out.println(sb);
    }
}
