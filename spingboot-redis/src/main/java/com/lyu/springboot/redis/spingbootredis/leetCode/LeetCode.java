package com.lyu.springboot.redis.spingbootredis.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 18:23 2020/10/22
 * @Modified By:
 */
public class LeetCode {
    /**
     * 判断括号是否成对出现
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        int len;
        do {
            len = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (s.length() != len);

        return s.length() == 0;
    }

    public static boolean isValid2(String s) {
        //1.特判
        if(s.isEmpty()) {
            return true;
        }
        //2.创建辅助栈
        Stack<Character> stack = new Stack<>();
        //3.遍历
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        //4.返回
        return stack.isEmpty();
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                ints[0] = i;
                ints[1] = hash.get(nums[i]);
                return ints;
            }
            hash.put(target - nums[i], i);
        }
        return ints;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        int[] ints = new int[target + 1];
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        ints[1] = 1;
        ints[2] = 2;

        for (int i = 3; i <= target; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
            System.out.println( i + "--->" + ints[i]);
        }
        return ints[target];
    }


    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * @param ints
     * @return
     */
    public static int getMax(int[] ints) {
        int in, out, max = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                in = ints[i];
                out = ints[j];
                if (out < in) {
                    continue;
                }
                if (out - in > max) {
                    max = out - in;
                }
            }
        }

        return max;
    }

    /**
     * 【剑指offer】斐波那契数列 --Java实现
     * 1. 递归法
     * 1. 分析
     * 斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     * 根据公式可以直接写出：
     *
     * 2. 代码
     * public class Solution {
     *     public int Fibonacci(int n) {
     *         if(n<=1){
     *             return n;
     *         }
     *         return Fibonacci(n-1) + Fibonacci(n-2);
     *     }
     * }
     * 3. 复杂度
     * 时间复杂度：
     * 空间复杂度：
     *
     * 2. 优化递归
     * 1. 分析
     * 递归会重复计算大量相同数据，我们用个数组把结果存起来8！
     *
     * 2. 代码
     * public class Solution {
     *     public int Fibonacci(int n) {
     *         int ans[] = new int[40];
     *         ans[0] = 0;
     *         ans[1] = 1;
     *         for(int i=2;i<=n;i++){
     *             ans[i] = ans[i-1] + ans[i-2];
     *         }
     *         return ans[n];
     *     }
     * }
     * 3. 复杂度：
     * 时间复杂度：
     * 空间复杂度：
     *
     * 3. 优化存储
     * 1. 分析
     * 其实我们可以发现每次就用到了最近的两个数，所以我们可以只存储最近的两个数
     *
     * sum 存储第 n 项的值
     * one 存储第 n-1 项的值
     * two 存储第 n-2 项的值
     * 2. 代码
     * public class Solution {
     *     public int Fibonacci(int n) {
     *         if(n == 0){
     *             return 0;
     *         }else if(n == 1){
     *             return 1;
     *         }
     *         int sum = 0;
     *         int two = 0;
     *         int one = 1;
     *         for(int i=2;i<=n;i++){
     *             sum = two + one;
     *             two = one;
     *             one = sum;
     *         }
     *         return sum;
     *     }
     * }
     */




    public static void main(String[] args) {
//        String s = "{[]}";
//        System.out.println(isValid2(s));
//
//        Stack stack = new Stack();
//        stack.push("1");
//        stack.push("2");
//
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//
//        System.out.println(stack.size());
//        System.out.println(stack);
//
//        System.out.println("--------------------------");
//        System.out.println(JumpFloor(10));


        int[] ints = {7,1,5,3,6,7,4};

        System.out.println(getMax(ints));

    }

}
