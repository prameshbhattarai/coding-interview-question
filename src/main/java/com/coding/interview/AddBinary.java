package com.coding.interview;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Input: a = "11" b = "1"
 * Output: "100"
 */
public class AddBinary {

    /*
    We will be doing same as math addition
    first we will extract the int value from current index string
    for eg: a.charAt(i) - '0' will return
            char(1) - 0 = 1
            char(0) - 0 = 0
    after we get int value we will do addition but we need to change the decimal based value to binary
    if sum = 3 then value = sum / 2 = 1
                and rem = sum % 2 = 1
    if sum = 2 then value = sum / 2 = 1
                and rem = sum % 2 = 0
    if sum = 1 then value = sum / 2 = 0
                and rem = sum % 2 = 1
    if sum = 0 then value = sum / 2 = 0
                and rem = sum % 2 = 0

    and we will finally reverse the string to make the order
     */
    public String add(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, rem = 0;
        while (i >= 0 || j >= 0) {
            int sum = rem;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            builder.append(sum % 2);
            rem = sum / 2;
        }
        if (rem != 0) builder.append(rem);
        return builder.reverse().toString();
    }
}
