package com.coding.interview;

/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographically in this alien language.
 */
public class VerifyingAnAlienDictionary {

    private final int[] orderPosition = new int[26];
    
    public boolean isAlienSorted(String[] words, String order) {
        
        // create order position of the alien language
        for(int i = 0; i < order.length(); i++) {
            // it means 
            // order = "boxad"
            // b is in index 0
            // 'b' - 'a' = 1
            // orderPosition[1] which is of b, and its order is 0
            orderPosition[order.charAt(i) - 'a'] = i;
        }
        
        // now compare each corresponding words in words
        // if they are in lexicographically ordered or not
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i+1])) return false; 
        }
        
        return true;
    }
    
    private boolean isSorted(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            // we only need to compare first non equal character
            // to check if they are in-order or not
            if (str1.charAt(i) != str2.charAt(j)) {
                // return true if the first string char is less than of second string char
                return orderPosition[str1.charAt(i) - 'a'] < orderPosition[str2.charAt(j) - 'a'];
            }
            i++; j++;
        }
        return str1.length() < str2.length();
    }
    
}
