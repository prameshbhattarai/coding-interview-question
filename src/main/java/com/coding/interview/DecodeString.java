package com.coding.interview;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p>
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {

    private final Stack<String> textStack = new Stack<>();
    private final Stack<Integer> freqStack = new Stack<>();

    public String decode(String text) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < text.length()) {

            // if the char is freq then calculate the number
            // and insert it into the freqStack
            if (Character.isDigit(text.charAt(i))) {

                // we might have double digit freq
                // for eg: 12[a].. which means decoded string should have 12 a
                int freq = 0;
                while (Character.isDigit(text.charAt(i))) {
                    int currentCharValue = text.charAt(i) - '0';
                    freq = freq * 10 + currentCharValue;
                    i++;
                }
                freqStack.push(freq);
            } else if (text.charAt(i) == '[') {
                if (result.length() > 0) {
                    // insert previous cumulated text into the stack
                    // as we need to start new count
                    textStack.push(result.toString());
                    // reset the result
                    result.setLength(0);
                }
                i++;
            } else if (text.charAt(i) == ']') {
                // we are at the end of current encoded text
                // extract all the decoded text till now and insert it into the temp
                StringBuilder temp = new StringBuilder();
                if (!textStack.isEmpty()) {
                    temp.append(textStack.pop());
                }
                
                // extract freq count for current encoded text
                // create decoded text
                int freq = freqStack.pop();
                for (int count = 0; count < freq; count++) {
                    temp.append(result);
                }
                
                // re assign temp to result
                result = temp;
                i++;
            } else {
                result.append(text.charAt(i++));
            }
        }

        return result.toString();
    }
    
    public String recursiveDecode(String text) {
        Queue<Character> queue = new LinkedList<>();
        // insert all the text in the queue
        for(char c : text.toCharArray()) queue.offer(c);
        return recursive(queue);
    }
    
    // decode the single block at a time
    private String recursive(Queue<Character> queue) {
        StringBuilder result = new StringBuilder();
        int freq = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            // we might have double digit freq
            // for eg: 12[a].. which means decoded string should have 12 a
            if (Character.isDigit(c)) {
                freq = freq * 10 + c - '0';
            } else if (c == '[') {
                // new decoding started..
                // recursive call to the function
                String sub = recursive(queue);
                for (int i = 0; i < freq; i++) {
                    result.append(sub);
                }
                // reset the frequency
                freq = 0;
            } else if (c == ']') {
                break;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
