package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyingAnAlienDictionaryTest {

    private static final VerifyingAnAlienDictionary dictionary = new VerifyingAnAlienDictionary();
    
    private static final String[] words1 =  {"hello","leetcode"};
    private static final String order1 = "hlabcdefgijkmnopqrstuvwxyz";
    
    private static final String[] words2 =  {"word","world","row"};
    private static final String order2 = "worldabcefghijkmnpqstuvxyz";
    
    private static final String[] words3 =  {"apple","app"};
    private static final String order3 = "abcdefghijklmnopqrstuvwxyz";
    
    @Test
    public void test() {
        Assertions.assertTrue(dictionary.isAlienSorted(words1, order1));
        Assertions.assertFalse(dictionary.isAlienSorted(words2, order2));
        Assertions.assertFalse(dictionary.isAlienSorted(words3, order3));
    }
}
