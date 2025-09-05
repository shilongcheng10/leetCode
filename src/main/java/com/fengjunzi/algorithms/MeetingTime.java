package com.fengjunzi.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MeetingTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] time = s.replaceAll("\\[", "").replaceAll("]", "").split(",");
        List<int[]> times = new ArrayList<>();
        for (int i = 0; i < time.length; i+=2) {
            times.add(new int[]{Integer.parseInt(time[i]), Integer.parseInt(time[i+1])});
        }
        times.sort(Comparator.comparing(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            if (result.isEmpty() || result.getLast()[1] < times.get(i)[0]) {
                result.add(new int[]{times.get(i)[0], times.get(i)[1]});
            }else if (result.getLast()[1] >= times.get(i)[0]) {
                result.getLast()[1] = times.get(i)[1];
            }
        }
        String resultStr = result.stream().map(item -> "[" + item[0] + ", " + item[1] + "]").collect(Collectors.joining(", "));
        System.out.println("[" + resultStr + "]");


    }
}
