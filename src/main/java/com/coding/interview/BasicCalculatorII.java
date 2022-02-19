package com.coding.interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 *
 * Input: s = "3+2*2"
 * Output: 7
 *
 * Input: s = " 3/2 "
 * Output: 1
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculatorII {

    /*
        We will use stack to store each number.
        if the operation is for + then push the number in the stack
        if the operation is for - then push the negative number in the stack
        if the operation is for * then pop the last inserted number and multiply it with current evaluated number,
        and then push in the stack
        if the operation is for / then pop the last inserted number and divide it with current evaluated number,
        and then push in the stack
     */
    public int calculate(String expression) {
        Stack<Integer> stack = new Stack<>();

        int evalNumber = 0;
        char prevSign = '+';
        int i = 0;

        for (Character c : expression.toCharArray()) {

            // evaluate the number
            if (Character.isDigit(c)) {
                evalNumber = evalNumber * 10 + c - '0';
            }

            // if current char is sign or it is the last element
            // then, either we will push the last element in stack, if sign = (+ or -)
            // or we will pop last inserted number and (/ or *) it by current evalNumber
            if (!Character.isDigit(c) && c != ' ' || i == expression.length() -1) {

                // we will eval the operation based of previous sign
                switch (prevSign) {
                    case '+' -> stack.push(evalNumber);
                    case '-' -> stack.push(-evalNumber);
                    case '*' -> stack.push(stack.pop() * evalNumber);
                    case '/' -> stack.push(stack.pop() / evalNumber);
                }
                prevSign = c; // assign current sign as prev sign
                evalNumber = 0; // reset eval number
            }
            i++;
        }

        return stack.stream().reduce(0, Integer::sum);
    }
}
