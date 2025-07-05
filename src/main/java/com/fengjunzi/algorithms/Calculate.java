package com.fengjunzi.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *224. 基本计算器
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 */
public class Calculate {
    public int calculate(String s) {
        Deque<Character> operatorStack = new ArrayDeque<Character>();
        Deque<Integer> nums = new ArrayDeque<Integer>();
        nums.addLast(0);
        s = s.replaceAll(" ", "");
        int n = s.length();
        for(int i = 0; i < n;i++){
            char c = s.charAt(i);
            if(c == '('){
                operatorStack.addLast(c);
            }else if(c == ')'){
                while(!operatorStack.isEmpty() && operatorStack.peekLast() != '('){
                    int nums2 = nums.pollLast();
                    int nums1 = nums.pollLast();
                    char oper = operatorStack.pollLast();
                    int ops = cal(nums1, nums2, oper);
                    nums.addLast(ops);
                }
                operatorStack.removeLast();
            }else if(Character.isDigit(c)){
                int j = i;
                int res =0;
                while(j < n && Character.isDigit(s.charAt(j))){
                    res = res * 10 + (s.charAt(j++) - '0');
                }
                nums.addLast(res);
                i = j-1;
            }else{
                if(i > 0 && (s.charAt(i-1) == '(')){
                    nums.addLast(0);
                }
                if(!operatorStack.isEmpty() && operatorStack.peekLast()!='('){
                    int nums2 = nums.pollLast();
                    int nums1 = nums.pollLast();
                    char oper = operatorStack.pollLast();
                    int ops = cal(nums1, nums2, oper);
                    nums.addLast(ops);
                }
                operatorStack.addLast(c);
            }
        }
        while(!operatorStack.isEmpty()){
            if(nums.size() < 2){
                break;
            }
            int nums2 = nums.pollLast();
            int nums1 = nums.pollLast();
            char oper = operatorStack.pollLast();
            int ops = cal(nums1, nums2, oper);
            nums.addLast(ops);
        }
        return nums.peekLast();
    }
    private int cal(int nums1, int nums2, char oper){
        if(oper == '+'){
            return nums1+nums2;
        }
        if(oper == '-'){
            return nums1 - nums2;
        }
        return 0;
    }
}
