package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 *
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 */
public class LetterCasePermutation {

    public List<String> permute(String str) {
        List<String> permutations = new ArrayList<>();
        permute(permutations, 0, str, "");
        return permutations;
    }

    private void permute(List<String> permutations, int i, String str, String combination) {
        if (i == str.length()) {
            permutations.add(combination);
        } else {
            if (Character.isLetter(str.charAt(i))) {
                String character = str.substring(i, i + 1);
                permute(permutations, i + 1, str, combination + character.toUpperCase());
                permute(permutations, i + 1, str, combination + character.toLowerCase());
            } else {
                permute(permutations, i + 1, str, combination + str.charAt(i));
            }
        }
    }
}
