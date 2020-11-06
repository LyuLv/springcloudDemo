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




    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid2(s));

        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.size());
        System.out.println(stack);

        System.out.println("--------------------------");
        System.out.println(JumpFloor(10));

    }

}
