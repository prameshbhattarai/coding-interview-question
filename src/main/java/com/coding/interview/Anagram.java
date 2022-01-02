package com.coding.interview;

/**
 * Given two strings, write a function to determine whether they are anagrams.
 */
public class Anagram {

    /*
        We will create a frequency array to count the frequency of character in first string
        and in second string we will decrease the frequency of character
        and at last we will iterate the frequency array, if all the values in array are 0 then it is anagram
     */
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] frequency = new int[256]; // we are creating 256 sized array, as we will have 256 character in ASCII

        for (int i = 0; i < a.length(); i++) {
            frequency[a.charAt(i) - 'a']++;
            frequency[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) return false;
        }
        return true;
    }

}
