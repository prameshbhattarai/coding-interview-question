package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnalyzeUserWebsiteVisitPatternTest {

    private static final String[] username = new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
    private static final int[] timestamp = new int[] {1,2,3,4,5,6,7,8,9,10};
    private static final String[] websites = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};

    private static final String[] expectedSequence = new String[] {"home","about","career"};

    private static final AnalyzeUserWebsiteVisitPattern pattern = new AnalyzeUserWebsiteVisitPattern();

    @Test
    public void analyzeTest() {
        String[] actualSequence = pattern.mostVisitedPattern(username, timestamp, websites);
        Assertions.assertArrayEquals(expectedSequence, actualSequence);
    }
}
