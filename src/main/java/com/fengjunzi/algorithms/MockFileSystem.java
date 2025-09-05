package com.fengjunzi.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://blog.csdn.net/guorui_java/article/details/149710993
 */
public class MockFileSystem {
    String name;
    MockFileSystem parent;
    Map<String, MockFileSystem> children;
    public MockFileSystem(String name, MockFileSystem parent) {
        this.name = name;
        this.parent = parent;
        this.children = new HashMap<>();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cn = scanner.nextInt();
        scanner.nextLine();
        String[] input = new String[cn];
        for (int i = 0; i < cn; i++) {
            input[i] = scanner.nextLine();
        }
        MockFileSystem root = new MockFileSystem("/", null);
        MockFileSystem current =  root;
        String lastOutput = "";
        for(String s : input){
            String[] arr = s.split(" ");
            if (arr.length == 0){
                continue;
            }
            String command = arr[0];
            if(command.equals("pwd")){
                lastOutput = getOutputPath(current);
            }else if(command.equals("mkdir")){
                String path = arr[1];
                if (isValidPath(path) && !current.children.containsKey(path)){
                    current.children.put(path, new MockFileSystem(path, current));
                }
                lastOutput = "";
            }else if(command.equals("cd") && arr.length == 2){
                String path = arr[1];
                if(path.equals("...")){
                    if (current.parent != null){
                        current = current.parent;
                    }
                }else if(isValidPath(path) && current.children.containsKey(path)){
                    current = current.children.get(path);
                }
                lastOutput = "";
            }
        }
        if (!lastOutput.isEmpty()) {
            System.out.println(lastOutput);
        }
        scanner.close();

    }

    private static boolean isValidPath(String path){
        if(path == null || path.isEmpty()){
            return false;
        }
        for(char c : path.toCharArray()){
            if(c < 'a' || c > 'z'){
                return false;
            }
        }
        return true;
    }

    private static String getOutputPath(MockFileSystem current) {
        if(current.parent == null){
            return "";
        }
        Stack<String> output = new Stack<>();
        while(current.parent != null){
            output.push(current.name);
            current = current.parent;
        }
        StringBuilder sb = new StringBuilder("/");
        while(!output.isEmpty()){
            sb.append(output.pop()).append("/");
        }
        return sb.toString();
    }
}
