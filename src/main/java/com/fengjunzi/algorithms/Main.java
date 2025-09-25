package com.fengjunzi.algorithms;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String orderStr = in.nextLine();
        char[] order = new char[orderStr.length()];
        for (int i = 0; i < orderStr.length(); i++) {
            order[i] = orderStr.charAt(i);
        }
        int cn = in.nextInt();
        in.nextLine();
        Trie trie = new Trie();
        for (int i = 0; i < cn; i++) {
            trie.add(in.nextLine());
        }
        List<String> res = new ArrayList<>();
        Trie cur = trie;
        dfs(cur, order, res);
        res.forEach(System.out::println);
    }


    public static void dfs(Trie cur, char[] order, List<String> res) {
        if(!"".equals(cur.word)){
            for(int i = 0; i < cur.cn; i++){

                res.add(cur.word);
            }
        }
        if(cur.children.isEmpty()){
            return;
        }
        for(char ch : order){
            if(cur != null && cur.children.containsKey(ch)){
                Trie next = cur.children.get(ch);
                dfs(next, order, res);
                cur = cur.parent;
            }
        }

    }
    static class Trie {
        String word;
        Map<Character, Trie> children;
        Trie parent;
        int cn;
        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
            this.parent = null;
        }

        public void add(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                Trie child = cur.children.computeIfAbsent(ch, k -> new Trie());
                child.parent = cur;
                cur = child;
            }
            cur.word = word;
            cur.cn++;
        }

        }
    
}