package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramTest {

    @Test
    public void testIsAnagram() {
        Anagram anagram = new Anagram();
        Assertions.assertTrue(anagram.isAnagram("anagram", "nagaram"));
        Assertions.assertFalse(anagram.isAnagram("rat", "car"));
    }
}
