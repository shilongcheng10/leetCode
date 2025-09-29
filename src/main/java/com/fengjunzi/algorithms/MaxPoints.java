package com.fengjunzi.algorithms;//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
// 
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
//
// Related Topics 几何 数组 哈希表 数学 👍 613 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxPoints {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int res = 0;
        for(int i =0; i < n-1;i++){
            Map<String, Integer> map = new HashMap<>();
            int repeat = 0;
            int tmp_max= 0;
            for(int j = i+1; j < n;j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(x ==0 && y == 0){
                    repeat++;
                    continue;
                }
                int g = gcd(x, y);
                x = (g!=0) ? x/=g : x;
                y = (g!=0) ? y/=g : y;
                String tmp = y + "/" + x;
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, map.get(tmp));
            }
            res = Math.max(res, repeat+tmp_max +1);
        }
        return res;
    }
    public int gcd(int x, int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
