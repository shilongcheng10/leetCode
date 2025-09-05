package com.fengjunzi.algorithms;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://blog.csdn.net/guorui_java/article/details/142236085
 */
public class OpenSourceCommunity {
    public String name;
    public Integer watch;
    public Integer star;
    public Integer fork;
    public Integer issue;
    public Integer mr;
    public Integer heat;

    OpenSourceCommunity(String name, Integer watch, Integer star, Integer fork, Integer issue, Integer mr) {
        this.name = name;
        this.watch = watch;
        this.star = star;
        this.fork = fork;
        this.issue = issue;
        this.mr = mr;
    }


    public void calculateHeat(int[] weight) {
        this.heat = weight[0] * watch + weight[1] * star + weight[2] * fork + weight[3] * issue + weight[4] * mr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[5];
        for (int i = 0; i < 5; i++) {
            weight[i] = sc.nextInt();
        }
        List<OpenSourceCommunity> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int watch = sc.nextInt();
            int star = sc.nextInt();
            int fork = sc.nextInt();
            int issue = sc.nextInt();
            int mr = sc.nextInt();
            OpenSourceCommunity openSourceCommunity = new OpenSourceCommunity(name, watch, star, fork, issue, mr);
            openSourceCommunity.calculateHeat(weight);
            list.add(openSourceCommunity);
        }
        list.sort((p1, p2) -> {
            if (p1.heat != p2.heat) {
                return p2.heat - p1.heat;
            } else {
                return p1.name.toLowerCase().compareTo(p2.name.toLowerCase());
            }
        });
    }
}
