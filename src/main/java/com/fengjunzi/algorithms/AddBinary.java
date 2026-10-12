package com.fengjunzi.algorithms;//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1324 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class AddBinary {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int pm = m-1, pn = n -1;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        while(pm >=0 && pn >=0){
            char ca = a.charAt(pm);
            char cb = b.charAt(pn);
            int total = (ca - '0') + (cb - '0') + carry;
            int val = total % 2;
            carry = total /2;
            stack.push(val);
            pm--;
            pn--;
        }
        while(pm >= 0){
            char ca = a.charAt(pm);
            int total =  ca - '0' + carry;
            int val = total % 2;
            carry = total / 2;
            stack.push(val);
            pm--;
        }
        while(pn >=0){
            char cb = b.charAt(pn);
            int total = cb - '0' + carry;
            int val = total % 2;
            carry = total /2;
            stack.push(val);
            pn--;
        }
        if(carry !=0){
            stack.push(carry);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            sb.append(tmp);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
