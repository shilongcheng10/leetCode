package com.fengjunzi.algorithms;

import java.util.*;
/**
 * https://www.nowcoder.com/practice/78d972fe8df84d3eb99f58928e668e39?tpId=390&tqId=11348398&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37
 */
import java.util.stream.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class RealHWEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            List<Integer> C = Arrays.stream(in.nextLine().split(" ")).map(
                    Integer::parseInt).collect(Collectors.toList());
            List<Integer> G = Arrays.stream(in.nextLine().split(" ")).map(
                    Integer::parseInt).collect(Collectors.toList());
            ArrayDeque<Integer> CQ = new ArrayDeque<>();
            for (int i = 0; i < C.size(); i++) {
                int c = C.get(i);
                CQ.addLast(c);
            }

            ArrayDeque<Integer> GQ = new ArrayDeque<>();
            for (int i = 0; i < G.size(); i++) {
                int g = G.get(i);
                GQ.addLast(g);
            }
            while (!CQ.isEmpty() && !GQ.isEmpty()) {
                int attempts = 0;
                int maxAttempts = GQ.size();
                int currentC = CQ.removeFirst();
                while (!GQ.isEmpty() && attempts < maxAttempts) {
                    if (currentC == GQ.peekFirst()) {
                        int g = GQ.removeFirst();
                        break;
                    } else if (currentC> GQ.peekFirst()) {
                        while(!GQ.isEmpty() && currentC >= GQ.peekFirst()){
                            currentC -= GQ.removeFirst();
                        }
                        break;
                    } else {
                        GQ.addLast(GQ.removeFirst());
                        attempts++;
                    }
                }

            }
            System.out.println(GQ.size());
        }
    }
}