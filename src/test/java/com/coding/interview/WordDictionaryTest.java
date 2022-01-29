package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordDictionaryTest {

    private static final WordDictionary wordDictionary = new WordDictionary();

    @Test
    public void searchWord() {
        wordDictionary.add("bad");
        wordDictionary.add("ball");
        wordDictionary.add("apple");
        wordDictionary.add("apply");

        Assertions.assertTrue(wordDictionary.search("bad"));
        Assertions.assertTrue(wordDictionary.search("ball"));
        Assertions.assertTrue(wordDictionary.search("apple"));
        Assertions.assertTrue(wordDictionary.search("apply"));
        Assertions.assertFalse(wordDictionary.search("noWord"));
    }

    @Test
    public void searchWordWithDots() {
        wordDictionary.add("bad");
        wordDictionary.add("ball");
        wordDictionary.add("apple");
        wordDictionary.add("apply");

        Assertions.assertTrue(wordDictionary.search("b.."));
        Assertions.assertTrue(wordDictionary.search("bal."));
        Assertions.assertTrue(wordDictionary.search("app.."));
        Assertions.assertTrue(wordDictionary.search("appl."));
        Assertions.assertTrue(wordDictionary.search("app.y"));
    }
}
