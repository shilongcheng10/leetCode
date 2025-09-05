package com.fengjunzi.algorithms;

import java.util.*;

public class ZuoDianTi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int finalValue = input.nextInt();
        int numberCnt = input.nextInt();
        Integer[] nums = new Integer[numberCnt];
        for (int i = 0; i < numberCnt; i++) {
            nums[i] = input.nextInt();
        }
        processSecretLift(finalValue, nums);
    }

    private static void processSecretLift(int finalValue, Integer[] nums) {
        Arrays.sort(nums, (o1, o2) -> o2 - o1);
        int sum = getSum(finalValue, nums);
        int m = nums.length / 2 + (nums.length % 2 == 0 ? 0 : 1);
        int target = sum / 2;
        List<Integer> plusValues = new ArrayList<>();
        List<Integer> numValues = new ArrayList<>();
        for (Integer num : nums) {
            numValues.add(num);
        }
        getPlusValues(plusValues, 0, m, target, numValues);
        List<Integer> finalList = getMergedList(plusValues, numValues);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < finalList.size(); i++) {
            sb.append(finalList.get(i));
            if (i != finalList.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static List<Integer> getMergedList(List<Integer> plusValues, List<Integer> numValues) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < plusValues.size(); i++) {
            ret.add(plusValues.get(i));
            if (i < numValues.size()) {
                ret.add(numValues.get(i));
            }
        }

        return ret;
    }

    private static int getPlusValues(List<Integer> plusValues, int curSum, int m, int target, List<Integer> numValues) {
        if (plusValues.size() == m && curSum == target) {
            return curSum;
        }
        int tempSum = -1;
        List<Integer> bestPlusValues = new ArrayList<>();
        List<Integer> numberList4Best = new ArrayList<>();
        for (int i = 0; i < numValues.size(); i++) {
            int tempNum = numValues.get(i);
            if (curSum + tempNum > target) {
                continue;
            }
            plusValues.add(tempNum);
            numValues.remove(i);
            int tmp = getPlusValues(plusValues, curSum + tempNum, m, target, numValues);
            if (tmp == -1) {
                plusValues.removeLast();
                numValues.add(i, tempNum);
                continue;
            }
            if (tmp == target) {
                return target;
            }else if (tmp > tempSum && tmp < target) {
                tempSum = tmp;
                copyList(bestPlusValues, plusValues);
                copyList(numberList4Best, numValues);
            }
            plusValues.removeLast();
            numValues.add(i, tempNum);


        }
        if (tempSum == -1) {
            return -1;
        }
        copyList(plusValues, bestPlusValues);
        copyList(numValues, numberList4Best);
        return tempSum;
    }

    private static void copyList(List<Integer> target, List<Integer> source) {
        target.clear();
        target.addAll(source);
    }

    private static int getSum(int finalValue, Integer[] nums) {
        int ret = finalValue;
        for (int i = 0; i < nums.length; i++) {
            ret += nums[i];
        }
        return ret;
    }


}
