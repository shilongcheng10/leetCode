package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class LaJiDuanXinLanJie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cn = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> sendingMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> receivingMap = new HashMap<>();
        for (int i = 0; i < cn; i++) {
            int sender = sc.nextInt();
            int receiver = sc.nextInt();
            sendingMap.putIfAbsent(sender, new HashMap<>());
            receivingMap.putIfAbsent(receiver, new HashMap<>());
            sendingMap.get(sender).put(receiver, sendingMap.get(sender).getOrDefault(receiver, 0) + 1);
            receivingMap.get(receiver).put(sender, receivingMap.get(receiver).getOrDefault(sender, 0) + 1);
        }
        int target = sc.nextInt();
        sc.close();
        long L = sendingMap.get(target).entrySet().stream().filter(entry -> !sendingMap.containsKey(entry.getKey()) || !sendingMap.get(entry.getKey()).containsKey(target)).count();
        int M =  receivingMap.get(target).values().stream().reduce(Integer::sum).get();
        List<Integer> XList = sendingMap.get(target).entrySet().stream().filter(entry -> entry.getValue() >= 5)
                .filter(entry -> entry.getValue() - receivingMap.get(entry.getKey()).get(target) > 5).map(Map.Entry::getKey).toList();
        boolean valid = L > 5 || (sendingMap.get(target).values().stream().reduce(Integer::sum).get() -M) > 10 || !XList.isEmpty();
        System.out.println(valid + " " + L + " " + M);


    }
}
