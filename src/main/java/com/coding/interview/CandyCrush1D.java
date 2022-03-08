package com.coding.interview;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Input: "aaabbbc"
 * Output: "c"
 * Explanation:
 * 1. Remove 3 'a': "aaabbbbc" => "bbbbc"
 * 2. Remove 4 'b': "bbbbc" => "c"
 *
 * Input: "aabbbacd"
 * Output: "cd"
 * Explanation:
 * 1. Remove 3 'b': "aabbbacd" => "aaacd"
 * 2. Remove 3 'a': "aaacd" => "cd"
 *
 * Input: "aabbccddeeedcba"
 * Output: ""
 * Explanation:
 * 1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
 * 2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
 * 3. Remove 3 'c': "aabbcccba" => "aabbba"
 * 4. Remove 3 'b': "aabbba" => "aaa"
 * 5. Remove 3 'a': "aaa" => ""
 *
 * Input: "aaabbbacd"
 * Output: "acd"
 * Explanation:
 * 1. Remove 3 'a': "aaabbbacd" => "bbbacd"
 * 2. Remove 3 'b': "bbbacd" => "acd"
 */
public class CandyCrush1D {

    /*
    Approach:
    We will use stack to crush the string.

    We will create a pair of char and occurrence
    and in each insertion we will compare current char with top of stack
    if both are same we will update the occurrence of the char
    if the occurrence count is 3 then we will remove it from the stack
     */

    public String crush(String input) {
        Stack<ValueCount> stack = new Stack<>();

        char[] chars = input.toCharArray();

        for (char aChar : chars) {
            if (!stack.isEmpty() && stack.peek().val == aChar) {
                stack.peek().count += 1;
                if (stack.peek().count >= 3) {
                    stack.pop();
                }
            } else {
                stack.push(new ValueCount(aChar, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (ValueCount v : stack) {
            while (v.count > 0) {
                sb.append(v.val);
                v.count -= 1;
            }
        }

        return sb.toString();
    }

    private static class ValueCount {
        public char val;
        public int count;

        public ValueCount(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static void main(String... args) {
        CandyCrush1D c = new CandyCrush1D();
//        System.out.println(c.crush("aaabbbc"));
//        System.out.println(c.crush("aabbbacd"));
//        System.out.println(c.crush("aabbccddeeedcba"));
//        System.out.println(c.crush("deeedbbcccbdaa"));
        System.out.println(c.crush("aaabbbacd"));
    }

}
