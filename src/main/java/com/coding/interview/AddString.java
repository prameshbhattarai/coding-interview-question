package com.coding.interview;

/**
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 */
public class AddString {

    public String add(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, rem = 0;
        while (i >= 0 || j >= 0) {
            int sum = rem;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            builder.append(sum % 10);
            rem = sum / 10;
        }
        if (rem != 0) builder.append(rem);
        return builder.reverse().toString();
    }
}
